package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    20:22~20:33

    * 완전탐색 *
    (직관적인 완전탐색)

    - 모든 문제는 완전탐색으로 1차적인 접근 해볼것
    - 모든 조건식을 통과하면 정답

    택희 = A
    영훈 = B
    남규 = C
 */
public class BOJ_14568_230803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;

        for (int A = 0; A <= n; A++) {
            for (int B = 0; B <= n; B++) {
                for (int C = 0; C <= n; C++) {
                    if (A + B + C == n) { //남는 사탕은 없어야 한다.
                        if (C - B >= 2) { //남규는 영훈이보다 2개 이상 많은 사탕을 가져야 한다.
                            if (A > 0 && B > 0 && C > 0) { //셋 중 사탕을 0개 받는 사람은 없어야 한다.
                                if (A % 2 == 0) { //택희가 받는 사탕의 수는 홀수개가 되어서는 안 된다.
                                    result++;
                                }
                            }
                        }
                    }

                }
            }
        }
        System.out.println(result);
    }
}
