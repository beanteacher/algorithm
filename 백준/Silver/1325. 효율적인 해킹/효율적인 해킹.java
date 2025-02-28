import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static int[] hackingCount;
    static int max = 0;

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.length];

        queue.offer(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n + 1];
        hackingCount = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[b].add(a);  // b가 a를 신뢰한다는 것은 a를 해킹하면 b도 해킹 가능
        }

        for (int i = 1; i <= n; i++) {
            hackingCount[i] = bfs(i);
            max = Math.max(max, hackingCount[i]); // 최댓값 업데이트
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (hackingCount[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
