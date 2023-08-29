package SWEA.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Battle_No2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String BinaryString = Integer.toBinaryString(M);

            if (BinaryString.length() < N) {
                sb.append(String.format("#%d %s\n", tc, "OFF"));
                continue;
            }

            String BinarySplit = BinaryString.substring(BinaryString.length() - N);
            if (BinaryString.length() < N || BinarySplit.contains("0")) {
                sb.append(String.format("#%d %s\n", tc, "OFF"));
                continue;
            }

            sb.append(String.format("#%d %s\n", tc, "ON"));
        }

        System.out.println(sb);

    }
}
