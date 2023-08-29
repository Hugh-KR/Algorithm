package BOJ.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1439_230620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();

        StringTokenizer st1 = new StringTokenizer(S, "0");
        StringTokenizer st0 = new StringTokenizer(S, "1");

        sb.append(Math.min(st1.countTokens(), st0.countTokens()));
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
