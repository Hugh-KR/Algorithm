package SWEA.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_Battle_No3 {
    static int[][] dp;
    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();
            dp = new int[str.length()][16];
            first_day(str, dp);

            for (int i = 1; i < str.length(); i++) {
                other_day(str, dp, i);
            }

            sb.append(String.format("#%d %d\n", tc, sol(dp)));
        }
        System.out.println(sb);
    }

    static void first_day(String keys, int[][] dp) {
        int key = 1 << (keys.charAt(0) - 'A');
        for (int i = 1; i < 16; i++) {
            if ((i & key) != 0 && (i & 1) != 0) dp[0][i] = 1;
        }
    }

    static void other_day(String keys, int[][] dp, int day) {
        int key = 1 << (keys.charAt(day) - 'A');
        for (int i = 1; i < 16; i++) {
            if (dp[day - 1][i] != 0) {
                for (int j = 1; j < 16; j++) {
                    if ((j & i) != 0 && (j & key) != 0){
                        dp[day][j] += dp[day - 1][i];
                        dp[day][j] %= mod;
                    }
                }
            }
        }
    }

    static int sol(int[][] dp){
        int sum = 0;
        for (int i = 1; i < 16; i++){
            sum += dp[dp.length-1][i];
            sum %= mod;
        }
        return sum;
    }
}
