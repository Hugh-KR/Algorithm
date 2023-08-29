package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1106_230630 {
    /**
     * DP? 왜지?
     * 적어도 C명 늘리기 위해 = 넘거나 작아도 된다?
     *
     * 최소 C명 늘리기위한 최소비용
     * C보다 큰 값에서 최소비용이 나올 수 있다.
     *
     * 비용은 정수배 만큼 늘어난다.
     *
     * dp[i] = 1명의 고객을 늘리기위한 최소비용
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0; // 0명의 고객을 늘리기위한 비용은 0

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int upCnt = Integer.parseInt(st.nextToken());
            for (int j = upCnt; j < c + 101; j++) {

                // 점화식 (배수로 늘어나도록)
                // j - upCnt
                // dp[5] = Math.min(dp[5], cost + dp[5 - 5]
                // dp[10] = Math.min(dp[10], cost + dp[10 - 5]
                // dp[15] = Math.min(dp[15], cost + dp[15 - 5]
                int pre = dp[j-upCnt];

                // 아직 정의되지않은 값 = 뛰어넘기 (overflow 발생하기때문)
                if (pre != Integer.MAX_VALUE) dp[j] = Math.min(dp[j], cost + pre);
            }

        }

        // C부터 시작하여 최솟값 찾기
        int result = Integer.MAX_VALUE;
        for (int i = c; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }

        System.out.println(result);
    }
}
