import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[100001];

        System.out.println(bfs(n));
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current == k) {
                return visited[current]-1;
            }

            if(current-1 >= 0 && visited[current-1] == 0) {
                visited[current-1] = visited[current] + 1;
                queue.offer(current-1);
            }
            if(current+1 <= 100000 && visited[current+1] == 0) {
                visited[current+1] = visited[current] + 1;
                queue.offer(current+1);
            }
            if(current*2 <= 100000 && visited[current*2] == 0) {
                visited[current*2] = visited[current] + 1;
                queue.offer(current*2);
            }
        }
        return -1;
    }
}