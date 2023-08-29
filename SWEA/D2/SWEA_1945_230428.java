package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1945_230428 {
    static int T;
    static int[] sosu = {2, 3, 5, 7, 11};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] result = new int[5];
            sb.append(String.format("#%d ", i));
            for (int j = 0; j < 5; j++) {
                while (N % sosu[j] == 0) {
                    N /= sosu[j];
                    result[j]++;
                }
                sb.append(result[j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
