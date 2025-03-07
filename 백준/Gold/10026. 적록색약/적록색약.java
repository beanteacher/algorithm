import java.io.*;

public class Main {
    static boolean[][] visited;
    static int count;
    static int n;
    static int[] xy1 = {0, 0, -1, 1};
    static int[] xy2 = {1, -1, 0, 0};

    static void dfs(int x, int y, char[][] arr) {
        if(!visited[x][y]) {
            visited[x][y] = true;

            for(int i = 0; i < 4; i++) {
                int xLine = x + xy1[i];
                int yLine = y + xy2[i];
                if((xLine >= 0 && xLine < n) && (yLine >= 0 && yLine < n) && !visited[xLine][yLine] && arr[x][y] == arr[xLine][yLine]) {
                    dfs(xLine, yLine, arr);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[][] redGreenBlue = new char[n][n];
        char[][] redBlue = new char[n][n];

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                redGreenBlue[i][j] = line.charAt(j);
                redBlue[i][j] = line.charAt(j) == 'G' ? 'R' : line.charAt(j);
            }
        }
        visited = new boolean[n][n];
        count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    count++;
                    dfs(i,j,redGreenBlue);
                }
            }
        }
        sb.append(count).append(" ");
        
        visited = new boolean[n][n];
        count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    count++;
                    dfs(i,j,redBlue);
                }
            }
        }
        sb.append(count);
        System.out.println(sb);
    }
}