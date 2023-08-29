package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    13:33~13:44

    *이친수*
    1. 이친수는 0으로 시작하지 않는다.
    2. 이친수에서는 1이 두 번 연속으로 나타나지 않는다.
    3. 즉 11을 부분 문자열로 갖지 않는다.

 */
public class BOJ_2193_230716 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[91];

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[1] = 1;
                continue;
            } if (i == 2) {
                dp[2] = 1;
                continue;
            } if (i == 3) {
                dp[3] = 2;
                continue;
            }

            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}
