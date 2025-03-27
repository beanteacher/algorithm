import java.util.*;
import java.io.*;

public class Main {

    static int[][] arr;
    static int m, n;
    static Queue<Tomato> queue = new LinkedList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static void bfs() {
        int day = 0;
        while(!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            day = tomato.day;
            
            for(int i = 0; i < 4; i++) {
                int newX = tomato.x + dx[i];
                int newY = tomato.y + dy[i];

                if(newX >= 0 && newX < n && newY >= 0 && newY < m && arr[newX][newY] == 0) {
                    queue.add(new Tomato(newX, newY, tomato.day+1));
                    arr[newX][newY] = 1;
                }
            }
        }
        
        if(checkTomato()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }
    
    static boolean checkTomato() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                if(arr[i][j] == 1) {
                    queue.add(new Tomato(i, j, 0));
                }
            }
        }
        
        bfs();
    }
}