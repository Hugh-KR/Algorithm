package BOJ.DP;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    위로 올라가면서 더하기
    Top-Down(재귀)
 */
public class BOJ_1932_230714 {
    static int N;
    static int[][] arr;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new Integer[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 맨 아래 값 넣어주기
        for (int i = 0; i < N; i++) {
            dp[N-1][i] = arr[N-1][i];
        }

        // 일단 아래로 쭉 내려가라
        System.out.println(find_sum(0, 0));
    }

    static int find_sum(int a, int b) {
        if (a == N-1) {
            return dp[a][b];
        }

        if (dp[a][b] == null) {
            // 더 큰 친구 비교해가며 위로 올라가
            dp[a][b] = Math.max(find_sum(a+1, b), find_sum(a+1, b+1)) + arr[a][b];
        }

        return dp[a][b];
    }
}
