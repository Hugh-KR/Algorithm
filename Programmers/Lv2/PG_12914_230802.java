package Programmers.Lv2;
import java.util.*;

/*
    16:21~16:36

    한번에 1칸 또는 2칸
    * DP *
    1 = 1
    2 = 2
    3 = 3
    4 = 5

    1차 시도 93.8
    2차 시도 100
*/
public class PG_12914_230802 {
    public long solution(int n) {

        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }

        return dp[n];
    }
}
