package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    13:06~

    *DP(바텀업)*

    규칙을 만족하며 모든 집을 칠하는 비용의 최솟값
    - 1번 집 색은 2번 집의 색과 같지 않아야 함
    - N번 집의 색은 N-1번 집의 색과 같지 않아야 함.
    - i(2 <= i <= N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

    - 집을 칠하는 비용은 1000보다 작거나 같은 자연수
 */
public class BOJ_1149_230829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] r = new int[n+1];
        int[] g = new int[n+1];
        int[] b = new int[n+1];
        int[][] dp = new int[n+1][4];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken());
            g[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());

        }

        dp[1][1] = r[1];
        dp[1][2] = g[1];
        dp[1][3] = b[1];

        for (int i = 2; i <= n; i++) {
            dp[i][1] = r[i] + Math.min(dp[i-1][2],dp[i-1][3]); // R
            dp[i][2] = g[i] + Math.min(dp[i-1][1],dp[i-1][3]); // G
            dp[i][3] = b[i] + Math.min(dp[i-1][1],dp[i-1][2]); // B
        }

        System.out.println(Math.min(dp[n][1], Math.min(dp[n][2], dp[n][3])));
    }
}
