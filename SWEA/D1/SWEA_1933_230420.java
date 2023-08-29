package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1933_230420 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        divisor(N);

        System.out.println(sb);
    }

    static void divisor(int N) {
        for (int i = 1; i <= N; i++) {
            if (10 % i == 0) {
                sb.append(i + " ");
            }
        }
    }
}
