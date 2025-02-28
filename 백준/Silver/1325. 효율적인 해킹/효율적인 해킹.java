import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, List<Integer>> adjList; // 인접리스트 구현
    static boolean[] visited; // bfs 방문 배열
    static Queue<Integer> queue = new LinkedList<>(); // bfs를 위한 queue
    static int hackingCountMax;
    static int[] hackingCountArr;

    static int bfs(int start) {
        int depth = 1;
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : adjList.get(node)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    depth++;
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new HashMap<>();
        hackingCountArr = new int[n+1];

        for(int i = 1; i < n+1; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(b).add(a); // a가 b를 신뢰하면 b를 해킹하면 a도 해킹할 수 있기 때문에 역방향으로 그래프 구현
        }

        for(int i = 1; i < n+1; i++) {
            visited = new boolean[n+1];
            hackingCountArr[i] = bfs(i);
            hackingCountMax = Math.max(hackingCountMax, hackingCountArr[i]); // 최댓값 업데이트
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < hackingCountArr.length; i++) {
            if(hackingCountMax == hackingCountArr[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
