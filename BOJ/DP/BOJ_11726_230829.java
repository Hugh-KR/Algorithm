package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    12:38~

    *DP(Bottom-Up)*

    - 가장 작은 크기부터 타일링 (2*n)
    - 규칙 찾아서 점화식 설계
    - 방법의 수 10007로 나눈 나머지
 */
public class BOJ_11726_230829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];


        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
                continue;
            }
            if (i == 2) {
                dp[i] = 2;
                continue;
            }

            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
