import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder dfsSb = new StringBuilder();
    static void dfs(int start) { // 재귀
        if(!dfsVisited[start]) {
            dfsSb.append(start).append(" ");
            dfsVisited[start] = true;
            for(int neighbor : adjList.get(start)) {
                dfs(neighbor);
            }
        }
    }
    static StringBuilder bfsSb = new StringBuilder();
    static void bfs() { // while문
        while(!queue.isEmpty()) {
            int node = queue.poll();
            bfsSb.append(node).append(" ");
            bfsVisited[node] = true;
            for(int neighbor : adjList.get(node)) {
                if(!bfsVisited[neighbor]) {
                    bfsVisited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    static Map<Integer, List<Integer>> adjList = new HashMap<>(); // 인접리스트 구현
    static boolean[] dfsVisited; // dfs 방문 배열
    static boolean[] bfsVisited; // bfs 방문 배열
    static Queue<Integer> queue = new LinkedList<>(); // bfs를 위한 queue
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n+1; i++) {
            adjList.put(i, new ArrayList<>()); // 인접리스트 초기화
        }
        dfsVisited = new boolean[n+1];
        bfsVisited = new boolean[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        for(Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            Collections.sort(entry.getValue()); // 결과는 노드를 작은 순으로 원하기 때문에 각각의 리스트를 오름차순으로 정렬해준다.
        }
        // dfs 탐색 시작
        dfs(v);
        // bfs 탐색 시작
        queue.offer(v); // 초깃값 설정
        bfs();

        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }
}