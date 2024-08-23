import java.io.*;

public class Main {
    static Integer[] dp = new Integer[1001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[0] = dp[1] = 1;

        System.out.print(fibonacci(n));
    }

    private static int fibonacci(int n) {
        if(dp[n] == null) {
            dp[n] = fibonacci(n-1) + fibonacci(n-2);
        }

        return dp[n] % 10007;
    }
}