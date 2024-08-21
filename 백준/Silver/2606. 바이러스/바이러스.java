import java.util.*;
import java.io.*;


public class Main {
    
    static int[][] map;
    static int node;
    static int edge;
    static boolean[] visit;
    static int count = 0;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        map = new int[node + 1][node + 1]; // 0번 인덱스 제외하고 사용
        visit = new boolean[node + 1];
        
        /*
        1 2
        2 3
        1 5
        5 2
        5 6
        4 7
        */
        for(int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        dfs(1);
        
        System.out.println(count);
    }
    
    private static void dfs(int start) {
        visit[start] = true;
        if(start > 1) count++;
        
        for(int i = 1; i < map[start].length; i++) {
            if(!visit[i] && map[start][i] == 1) {
                dfs(i);
            }
        }
    }
}