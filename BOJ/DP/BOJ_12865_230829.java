package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    11:23~11:45

    *DP(Bottom-Up)*

    - 넣거나 넣지 않거나를 바텀업 방식으로 구현
 */
public class BOJ_12865_230829 {
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] w = new int[n+1];
        int[] v = new int[n+1];
        int[][] dp = new int[n+1][k+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {

                if (w[i] > j) { // i번째 무개를 더 담을 수 없는 경우
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
