package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    dp는 문제를 일반화 시키는 과정이 중요하다.

    M개에서 N개를 선택 서로 중복되면 안됨 = 조합 공식
    1. 다리끼리 겹쳐질 수 없음.
    2. N <= M

    dp[i][j]
    i = 동쪽
    j = 서쪽

    Bottom-up 방식은 반대로 생각하면 된다?
    점화식 = dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
 */
public class BOJ_1010_230716{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        long[][] dp = new long[30][30];
        // 2번 성질 (n0 = nn = 1)
        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) { // M
            for (int j = 1; j <= i; j++) { // N (N<=M)
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }


        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // M개중 N개를 뽑는 경우이므로 dp[m][n]
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(dp[m][n]);
        }

    }
}
