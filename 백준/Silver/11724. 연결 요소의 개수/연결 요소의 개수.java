import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    static void dfs(int start) {
        if(!visited[start]) {
            for(int neighbor : arr[start]) {
                visited[start] = true;
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);
        }

        int result = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }
}