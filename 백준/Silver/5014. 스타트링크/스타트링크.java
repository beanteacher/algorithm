import java.io.*;
import java.util.*;

public class Main {
    static int total;
    static int start;
    static int destination;
    static int up;
    static int down;

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[total + 1];
        Arrays.fill(visited, -1);

        visited[start] = 0;
        queue.offer(start);

        while(!queue.isEmpty()) {
            int currentStair = queue.poll();

            if(currentStair == destination)  return visited[currentStair];

            int nextUp = currentStair + up;
            if(nextUp <= total && visited[nextUp] == -1) {
                visited[nextUp] = visited[currentStair] + 1;
                queue.offer(nextUp);
            }
            int nextDown = currentStair - down;
            if(nextDown >= 1 && visited[nextDown] == -1) {
                visited[nextDown] = visited[currentStair] + 1;
                queue.offer(nextDown);
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        total = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken()); // 시작점
        destination = Integer.parseInt(st.nextToken()); // 목적지
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());

        int result = bfs();
        System.out.println(result == -1 ? "use the stairs" : result);
    }
}