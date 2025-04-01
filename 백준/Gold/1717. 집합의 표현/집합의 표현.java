import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;

    static int find(int a) {
        if(arr[a] == a) {
            return a;
        } else {
            return find(arr[a]);
        }
    }

    static void union(int a, int b) {
        int x = find(a);
        int y = find(b);

        arr[y] = x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];

        for(int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int digits = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(digits == 1) {
                if(find(a) == find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            } else {
                union(a,b);
            }
        }

        System.out.println(sb);
    }
}