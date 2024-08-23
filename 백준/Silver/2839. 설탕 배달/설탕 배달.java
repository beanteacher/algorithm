import java.util.*;
import java.io.*;

public class Main {
    static int INF = 5000;
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num+1];
        
        Arrays.fill(dp,INF);
        
        if(num >= 3) dp[3] = 1;
        if(num >= 5) dp[5] = 1;
        
        for(int i = 6; i <= num; i++) {
            dp[i] = Math.min(dp[i-3], dp[i-5]) + 1;
        }
        
        System.out.print(dp[num] >= INF ? -1 : dp[num]);
    }
}