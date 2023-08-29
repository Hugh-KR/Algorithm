package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    1 = {1} 1개
    2 = {1+1, 2} 2개
    3 = {1+1+1, 1+2, 2+1, 3} 4개

    *점화식*
    dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
 */
public class BOJ_9095_230714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int dp[] = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        System.out.println(sb);
    }
}
