package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    14:40~

    *DP(누적합)*


 */
public class BOJ_2559_230809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[n+1];

        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
            dp[i] += dp[i-1];

            if (i >= k) { // i >= k 부터 모든 경우 비교
                max = Math.max(max, dp[i] - dp[i-k]);
            }
        }

        System.out.println(max);
    }
}
