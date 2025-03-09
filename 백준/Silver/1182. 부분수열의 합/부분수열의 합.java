import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int s;
    static int[] arr;
    static int count;
    static void dfs(int index, int numCount, int sum, boolean[] visited) {
        if(numCount == n+1) {
            return;
        }
        if(sum == s) {
            count++;
        }
        visited[index] = true;
        // System.out.println("numCount : " + numCount + " , sum : " + sum + ", visited : " + Arrays.toString(visited));
        for(int i = ++index; i < n; i++) {
            if(!visited[index]) {
                dfs(i, numCount+1, sum + arr[i], visited.clone());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, 1, arr[i], visited);
        }

        System.out.println(count);
    }
}