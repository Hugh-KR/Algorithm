package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    21:25~21:37

    * 정수론 *
    1 <= N <= 1000만

    N을 소인수분해 한 결과
 */
public class BOJ_11653_230806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int cnt = 2;
        while (true) {
            if (n == 1) break;

            if (n % cnt == 0) {
                n /= cnt;
                sb.append(cnt).append("\n");
            } else {
                cnt++;
            }
        }

        System.out.println(sb);
    }
}
