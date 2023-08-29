package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    21:16~21:23
    (Easy~)

    * 정수론 *

    제곱근을 이용한 소수 검증
 */
public class BOJ_1978_230806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (isPrime(a)) result++;
        }

        System.out.println(result);
    }

    //소수 검증
    static boolean isPrime(int a) {
        if (a == 1) return false;
        if (a == 2) return true;

        for (int i = 2; i <= Math.sqrt(a); i++) { //제곱근 으로 소수 검증
            if (a % i == 0) return false;
        }

        return true;
    }
}
