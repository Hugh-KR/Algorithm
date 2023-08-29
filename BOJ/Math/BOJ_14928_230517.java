package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14928_230517 {
    static String N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = br.readLine();

        int remain = 0;
        for (int i = 0; i < N.length(); i++) {
            remain = (remain * 10 + (N.charAt(i) - '0')) % 20000303;
        }
        sb.append(remain);
        System.out.println(sb);
    }
}
