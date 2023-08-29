package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;


/*
    21:40~
    (23.08.07) 12:22
    에라토스테네스의 체 - "소수가 되는 수의 배수를 지우면 남은건 소수가 된다."
    (블로그 참조)

    *정수론*
    2 <= k <= 1조

    k는 훔쳐올 보석들의 곱
    곱해진 대로 최대한 많은 보석

    제곱근까지 구하기?
    쉽게 생각해 보자
    숫자로 장난치는 방법을 알아보자
    100만까지 소수 만들기?
    앞을 구하면 뒤는 안구해도 됨

    최대 개수를 구하는 것

    아주 많은 시도 - 100
 */
public class BOJ_14232_230806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long k = Long.parseLong(br.readLine());

        ArrayList<String> list = new ArrayList<>();

        int cnt = 0;
        int idx = 2;
        while (k != 1) {
            // 종료 조건
            if (idx >= Math.sqrt(k)+1) { // 제곱근 까지만 보면 약수 파악 가능
                list.add(k + "");
                cnt++;
                break;
            }

            if (k % idx == 0) {
                list.add(idx + "");
                k /= idx;
                cnt++;
            } else {
                idx++;
            }
        }
//        for (int i = 2; i <= Math.sqrt(k); i++) {
//            if (k % i == 0) {
//                cnt++;
//                list.add((long)i);
//                list.add(k/i);
//
//            }
//        }


//        sb.append(list.size()).append("\n");
//        sb.append(String.join(" ", list));
//
        System.out.println(cnt);
        System.out.println(String.join(" ", list));
    }
}
