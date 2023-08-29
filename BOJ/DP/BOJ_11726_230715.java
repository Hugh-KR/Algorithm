package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    10,007 으로 나눈 나머지
    DP의 핵심은 Memorization 과 점화식

    *경우의 수*
    1 = 1
    2 = 2
    3 = 3
    4 = 5
 */
public class BOJ_11726_230715 {
    static int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[1] = 1;
                continue;
            } if (i == 2) {
                dp[2] = 2;
                continue;
            } if (i == 3) {
                dp[3] = 3;
                continue;
            }
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }

        System.out.println(dp[n]);
    }
}
