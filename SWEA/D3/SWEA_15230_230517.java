package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_15230_230517 {
    static int T;
    static char[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String isAlpha = br.readLine();
            alpha = new char[26];

            for (int j = 0; j < 26; j++) {
                char ap = (char)('a' + j);
                alpha[j] = ap;
            }

            int cnt = 0;
            for (int j = 0; j < isAlpha.length(); j++) {
                if (isAlpha.charAt(j) == alpha[j]) cnt++;
                else break;
            }

            sb.append(String.format("#%d %d\n", i, cnt));
        }
        System.out.println(sb);
    }
}
