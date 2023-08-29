package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727_230407 {
    static long[] dp = new long[1001];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= 1000; i++) {
            dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10007;
        }

        System.out.println(dp[N]);
    }
}
