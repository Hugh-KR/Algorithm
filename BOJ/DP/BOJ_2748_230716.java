package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2748_230716 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];

        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[1] = 1;
                continue;
            }
            if (i == 2) {
                dp[2] = 1;
                continue;
            }
            if (i == 3) {
                dp[3] = 2;
                continue;
            }

            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);

    }
}
