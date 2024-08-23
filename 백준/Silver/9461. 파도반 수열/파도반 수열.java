import java.util.*;
import java.io.*;

public class Main {
    
    static Long[] dp = new Long[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCount; i++) {
            int n = Integer.parseInt(br.readLine());


            dp[1] = dp[2] = dp[3] = 1L;

            System.out.println(padovan(n));
        }
    }

    private static long padovan(int n) {
        if(dp[n] == null) {
            dp[n] = padovan(n-2) + padovan(n-3);
        }
        return dp[n];
    }
}