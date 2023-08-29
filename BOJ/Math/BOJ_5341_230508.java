package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5341_230508 {
    static int T;
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            T = Integer.parseInt(br.readLine());
            if (T == 0) {
                break;
            }
            sum = 0;
            for (int i = 1; i <= T; i++) {
                sum += i;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
