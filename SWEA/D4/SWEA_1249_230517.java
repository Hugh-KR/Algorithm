package SWEA.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1249_230517 {
    static int T, N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for (int j = 0; j < N; j++) {
                String str = br.readLine();
                for (int k = 0; k < N; k++) {
                    arr[j][k] = Integer.parseInt(String.valueOf(str.charAt(k)));
                }
            }


        }
    }
}
