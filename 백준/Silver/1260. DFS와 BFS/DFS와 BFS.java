import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder dfsSb = new StringBuilder();
    static void dfs(int start) {
        if(!dfsVisited[start]) {
            dfsSb.append(start).append(" ");
            dfsVisited[start] = true;
            for(int neighbor : adjList.get(start)) {
                dfs(neighbor);
            }
        }
    }
    static StringBuilder bfsSb = new StringBuilder();
    static void bfs() {
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

    static Map<Integer, List<Integer>> adjList = new HashMap<>();;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n+1; i++) {
            adjList.put(i, new ArrayList<>());
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
            Collections.sort(entry.getValue());
        }

        dfs(v);
        queue.offer(v);
        bfs();

        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }
}