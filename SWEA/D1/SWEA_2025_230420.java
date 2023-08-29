package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2025_230420 {
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(totalSum(N));
    }

    static int totalSum(int N) {
        int cnt = 0;
        while (N > 0) {
            cnt += N;
            N--;
        }

        return cnt;
    }
}
