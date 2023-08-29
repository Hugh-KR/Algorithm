package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14652_230516 {
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int seat = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (seat == K) {
                    sb.append(String.format("%d %d\n", i, j));
                }
                seat++;
            }
        }
        System.out.println(sb);
    }
}
