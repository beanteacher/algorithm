import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    static void dfs(int start) {
        // 방문하지 않은 노드라면 
        if(!visited[start]) {
            visited[start] = true; // 방문 여부 체크
            // 인접 노드들을 재귀하여 방문 여부 체크
            for(int neighbor : arr[start]) {
                dfs(neighbor);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // 인접 리스트 초기화
        arr = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>(); // 각각의 리스트 초기화
        }
        visited = new boolean[n+1]; // 방문 리스트 초기화

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[u].add(v); // 인접 노드들 추가 (무방향 그래프)
            arr[v].add(u); // 인접 노드들 추가 (무방향 그래프)
        }

        int result = 0;
        for(int i = 1; i <= n; i++) {
            // dfs 탐색으로 방문하지 않았던 노드는 서로 연결되어 있지 않은 그래프
            // 연결 요소의 개수 : 그래프를 한 개라고 줘 놓고 여러 component로 뚝뚝 떨어진 그래프의 개수
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }
}