package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1545_230420 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        reverseNum(N);

        System.out.println(sb);
    }

    static void reverseNum(int N) {
        for (int i = N; i >= 0; i--) {
            sb.append(i + " ");
        }
    }
}
