import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n;
    static boolean[][] visited;
    static int dirX[] = {0, 0, -1, 1};
    static int dirY[] = {-1, 1, 0, 0};
    static int count = 0;

    static List<Integer> aptNum = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 지도의 크기
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) == '0' ? 0 : 1;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    dfs(i, j);
                    aptNum.add(count);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(aptNum.size()).append("\n");
        Collections.sort(aptNum);
        for(int i = 0; i < aptNum.size(); i++) {
            sb.append(aptNum.get(i)).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for(int i = 0; i < 4; i++) {
            int nowX = dirX[i] + x;
            int nowY = dirY[i] + y;
            if(nowX >= 0 && nowX < n && nowY >= 0 && nowY < n && !visited[nowX][nowY] && map[nowX][nowY] == 1) {
                visited[nowX][nowY] = true;
                dfs(nowX, nowY);
            }
        }
    }
}