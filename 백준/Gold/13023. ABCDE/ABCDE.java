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

        for(int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());

            adjList.get(friend1).add(friend2);
            adjList.get(friend2).add(friend1);
        }

        for(int i = 0; i < n; i++) {
            dfs(i, 1);
            if(isFive) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
}