package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    13:44~

    이진dp?
 */
public class BOJ_2302_230716 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[1] = 1;
                continue;
            }
            if (i == 2) {
                dp[2] = 2;
                continue;
            }
            if (i == 3) {
                dp[3] = 3;
                continue;
            }
            if (i == 4) {
                dp[4] = 5;
                continue;
            }

            dp[i] = dp[i-1] + dp[i-2];
        }


        int cnt = 1;
        int pre = 0;
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(br.readLine());
            cnt *= dp[tmp - pre - 1];
            pre = tmp;
        }

        cnt *= dp[N - pre];

        System.out.println(cnt);

    }
}
