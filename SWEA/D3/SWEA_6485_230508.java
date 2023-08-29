package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6485_230508 {
    static int T, N, A, B, P, C;
    static int[] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            dp = new int[5001];
            N = Integer.parseInt(br.readLine());

            // 지나는 정류장 확인
            BusCheck();

            // 방문 댓수 확인 및 출력
            P = Integer.parseInt(br.readLine());
            sb.append(String.format("#%d ", i));
            for (int j = 0; j < P; j++) {
                C = Integer.parseInt(br.readLine());
                sb.append(dp[C] + " ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }

    static void BusCheck() throws IOException{
        for (int j = 0; j < N; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            for (int k = A; k <= B; k++) {
                dp[k]++;
            }
        }
    }
}
