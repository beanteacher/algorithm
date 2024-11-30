import java.io.*;
import java.util.*;
class Main {
    // BFS를 사용하여 두 점 사이의 최소 이동 거리 계산
    private static int bfs(Point start, Point end, int n) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[n][n];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        visited[start.x][start.y] = true; // 시작점 방문 처리

        int move = 0; // 이동 거리

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point current = queue.poll();

                // 목표 지점에 도달하면 이동 횟수 반환
                if (current.x == end.x && current.y == end.y) {
                    return move;
                }

                // 네 방향으로 탐색
                for (int[] dir : directions) {
                    int nx = current.x + dir[0]; // 다음 x 좌표
                    int ny = current.y + dir[1]; // 다음 y 좌표

                    // 격자 범위 내에 있고 아직 방문하지 않은 경우
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                        queue.add(new Point(nx, ny)); // 큐에 추가
                        visited[nx][ny] = true; // 방문 처리
                    }
                }
            }

            move++; // 현재 레벨이 끝나면 이동 횟수 증가
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] nArr = new int[n][n];
        Point[] pointArr = new Point[k + 1];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                nArr[i][j] = Integer.parseInt(st.nextToken());
                if(nArr[i][j] > 0) {
                    pointArr[nArr[i][j]] = new Point(i, j);
                }
            }
        }
        int result = 0;
        for(int i = 1; i < k; i++) {
            result += bfs(pointArr[i], pointArr[i+1], n);
        }

        System.out.println(result);
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
