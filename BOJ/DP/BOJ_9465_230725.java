package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    dp를 비교하면서 진행 (대각선 방향 앞에서 뒤를)
 */
public class BOJ_9465_230725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0)  {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[2][N+1];

            for (int x = 0; x < 2; x++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int y = 1; y <= N; y++) {
                    dp[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            for (int k = 2; k <= N; k++) {
                dp[0][k] += Math.max(dp[1][k-1], dp[1][k-2]);
                dp[1][k] += Math.max(dp[0][k-1], dp[0][k-2]);
            }

            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }

        System.out.println(sb);
    }

}
