package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3456_230515 {
    static int T, A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (A == B && B == C) sb.append(String.format("#%d %d\n", i, A));
            else if (A == B && B != C) sb.append(String.format("#%d %d\n", i, C));
            else if (A != B && B == C) sb.append(String.format("#%d %d\n", i, A));
            else if (A == C && B != C) sb.append(String.format("#%d %d\n", i, B));
        }
        System.out.println(sb);
    }
}
