import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;

    static int[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void dfs(int x, int y, int[][] tempArr, boolean[][] visited) {
        if(!visited[x][y]) {
            // System.out.println("x : " + x + " , y : " + y);
            int zeroCount = 0;
            visited[x][y] = true;

            for(int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
                    if(tempArr[newX][newY] == 0) {
                        zeroCount++;
                    } else {
                        dfs(newX, newY, tempArr, visited);
                    }
                }
            }
            arr[x][y] = arr[x][y] - zeroCount > 0 ? arr[x][y] - zeroCount : 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] tempArr = new int[n][m];

        int year = 0;
        while(true) {
            int glacierCount = 0;
            boolean[][] visited = new boolean[n][m];

            for(int i = 0; i < n; i++) {
                tempArr[i] = arr[i].clone();
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    // System.out.println("i : " + i + ", j : " + j + ", arr[i][j] : " + arr[i][j] + ", visited[i][j] : " + visited[i][j]);
                    if(tempArr[i][j] > 0 && !visited[i][j]) {
                        dfs(i, j, tempArr, visited);
                        glacierCount++;
                    }
                }
            }
            // System.out.println("glacierCount : " + glacierCount + "year : " + year);
            if(glacierCount >= 2) {
                System.out.println(year);
                break;
            }

            if(glacierCount == 0) {
                System.out.println(0);
                break;
            }
            year++;
        }
    }
}