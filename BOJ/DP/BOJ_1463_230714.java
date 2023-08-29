package BOJ.DP;

import java.io.*;

/*
    dp 풀이

    x % 3 == 0 -> 3로 나눈다
    x % 2 == 0 -> 2로 나눈다
    1을 뺀다

    큰 수로 먼저 나누는게 이득
    N 최댓값 - 100만

    점화식
    dp[i] = Math.min(dp[i-1]+1, dp[i/2]+1, dp[i/3]+1);
 */
public class BOJ_1463_230714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1]+1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }

        System.out.println(dp[N]);
    }
}
