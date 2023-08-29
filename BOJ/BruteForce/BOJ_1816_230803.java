package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    17:26~

    * 완전탐색 *

    100만 (10^6) 보다 큰 소수이면 매우 큰 소수
    - S의 모든 소인수가 100만 보다 크다면 적절한 암호키
    - 2~100만 까지 나누면서 완전탐색?
    - 100만 * 10 = 1000만
 */
public class BOJ_1816_230803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            long s = Long.parseLong(br.readLine());
            String result = "YES";

            for (int j = 2; j <= 1000000; j++) {
                if (s % j == 0) {
                    result = "NO";
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
