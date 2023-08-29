package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    10:46~

    *DP(Bottom-Up)*

    - 기존 탑다운 방식, 바텀업 방식으로 구현
 */
public class BOJ_14501_230829 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+2];
        int[] t = new int[n+2];
        int[] p = new int[n+2];


        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(dp);

        for (int i = n; i >= 1; i--) {
            if (t[i]+i > n+1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], dp[i+t[i]] + p[i]);
            }
        }

        System.out.print(dp[1]);

    }

}
