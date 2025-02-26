import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, List<Integer>> adjList = new HashMap<>(); // 인접 리스트 구현
    static boolean[] visited;
    static boolean isFive;

    static void dfs(int start, int depth) {
        if(depth == 5) {
            isFive = true;
            return;
        }
        if(adjList.get(start) == null) {
            return;
        }
        
        visited[start] = true;
        for(int neighbor : adjList.get(start)) {
            if(!visited[neighbor]) {
                dfs(neighbor, depth+1);
            }
        }
        visited[start] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());

            List<Integer> list1 = adjList.getOrDefault(friend1, new ArrayList<>());
            List<Integer> list2 = adjList.getOrDefault(friend2, new ArrayList<>());
            list1.add(friend2);
            list2.add(friend1);
            adjList.put(friend1, list1);
            adjList.put(friend2, list2);
        }

        for(int i = 0; i < n; i++) {
            dfs(i, 1);
            if(isFive) { // 친구관계가 5단계까지 이어져 있는 사람이 있다면 1 출력
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}