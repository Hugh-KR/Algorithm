package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2019_230420 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        square(N);

        System.out.println(sb);
    }

    static void square(int N) {
        int num = 1;
        while (N >= 0) {
            sb.append(num + " ");
            num *= 2;
            N--;
        }
    }
}
