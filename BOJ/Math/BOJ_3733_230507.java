package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3733_230507 {
    static int N, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String cur = br.readLine();
            if (cur == null) break;


            StringTokenizer st = new StringTokenizer(cur);
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            sb.append(S / (N + 1) + "\n");
        }
        System.out.println(sb);
    }
}
