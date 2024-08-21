import java.util.*;
import java.io.*;


public class Main {

    static int width, height, num; // 가로, 세로, 배추 수
    static int[][] map; // 배추 밭
    static boolean[][] visit; // 방문 배열
    static int[] dx= {0, 0, -1, 1};
    static int[] dy= {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0; i < testCount; i++) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            num = Integer.parseInt(st.nextToken());

            map = new int[width][height];
            visit = new boolean[width][height];

            for(int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            int bugCount = 0;

            for(int j = 0; j < width; j++) {
                for(int k = 0; k < height; k++) {
                    if(map[j][k] == 1 && !visit[j][k]) {
                        bugCount++;
                        bfs(j, k);
                    }
                }
            }
            System.out.println(bugCount);
        }
    }

    private static void bfs(int width, int height) {

        visit[width][height] = true;

        for(int i = 0; i < dx.length; i++) {
            try {
                if(!visit[width-dx[i]][height-dy[i]] && map[width-dx[i]][height-dy[i]] == 1) {
                    bfs(width-dx[i], height-dy[i]);
                }
            } catch (Exception e) {
                String str = "IndexOutOfRange";
            }
        }
    }
}