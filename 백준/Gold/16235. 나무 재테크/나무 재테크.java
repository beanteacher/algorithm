import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] ground = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                ground[i][j] = 5;
            }
        }
        /*
        for(int i = 1; i <= n; i++) { // 이렇게 채워도 되지만 0인 위치를 0으로 채우지 않기 위해 위의 방법으로 수행했다.
            Arrays.fill(ground[i], 5);
        }
        */
        int[][] food = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<Integer>[][] tree = new PriorityQueue[n+1][n+1]; // r,c 위치에 나무가 2개 이상 심어질 수 있고, 나이가 적은 나무부터 양분을 주므로 나이의 최솟값을 찾아오기 쉬운 자료구조 힙으로 선언
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <= n; j++) {     
                tree[i][j] = new PriorityQueue<>();
            }
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            tree[r][c].offer(age); // 해당 땅에 나이가 age인 나무 한 그루 추가
        }
        int[] xyz1 = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] xyz2 = {-1, 0, 1, -1, 1, -1, 0, 1};
        Queue<Integer>[][] deadTree = new LinkedList[n+1][n+1];
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <= n; j++) {
                deadTree[i][j] = new LinkedList<>();
            }
        }
        // 년수
        for(int i = 1; i <= k; i++) {
            // 봄
            for(int j = 1; j <= n; j++) {
                for(int l = 1; l <= n; l++) {
                    List<Integer> eatFoodTrees = new ArrayList<>(); // 봄에 양분을 먹일 때 양분을 먹인 나무를 담아둘 List
                    PriorityQueue<Integer> treeHeap = tree[j][l];
                    while(!treeHeap.isEmpty()) {
                        int age = treeHeap.poll(); // 나무 나이의 최솟값
                        if(age > ground[j][l]) {
                            deadTree[j][l].offer(age); // 땅에 양분이 부족해 나무가 죽는다.
                        } else {
                            ground[j][l] -= age; // 나무가 자신의 나이만큼 양분을 먹어 해당 땅에 양분이 적어진다.
                            eatFoodTrees.add(age+1); // 양분을 먹인 나무를 temp 리스트에 넣어둔다.
                        }
                    }
                    for(int eatFoodTree : eatFoodTrees) { // 양분을 먹인 나무를 다시 나무 힙에 넣어준다.
                        treeHeap.offer(eatFoodTree);
                    }
                }
            }
            // 여름 : 양분보다 나무의 나이가 많아 나무가 죽어 양분이 된다.
            for(int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    Queue<Integer> deadTreeQueue = deadTree[j][l];
                    while(!deadTreeQueue.isEmpty()) {
                        ground[j][l] += deadTreeQueue.poll() / 2;
                    }
                }
            }
            // 가을
            for(int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    for(int treeAge : tree[j][l]) {
                        if(treeAge % 5 == 0) { // 나이가 5의 배수이면 증식
                            for(int o = 0; o < 8; o++) { // 인접한 8개의 칸에 나이가 1인 나무 심기
                                int x = j + xyz1[o];
                                int y = l + xyz2[o];
                                if(x > 0 && x <= n && y > 0 && y <= n) { // 인접한 8개의 토지 중 토지가 아닌 곳에 심어지면 안되기 때문에 조건 추가
                                    tree[x][y].offer(1);
                                }
                            }
                        }
                    }
                }
            }
            // 겨울
            for(int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    ground[j][l] += food[j][l];
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result += tree[i][j].size();
            }
        }

        System.out.println(result);
    }
}