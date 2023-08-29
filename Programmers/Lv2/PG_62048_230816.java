package Programmers.Lv2;
import java.util.*;

/*
    10:17~

    *수학?*

    W H <= 1억 이하 자연수

    크기가 크다
    - 어떻게 잘라도 잘리는 부분은 같다?(가로 W, 세로 H 인 직사각형)

    (W*H) - 대각선
    규칙이 뭘까..

    4 = 8과 12의 최대 공약수
    대각선 규직 = (가로+세로)-1?

    1차 시도 - 실패
    2차 시도 -
*/
public class PG_62048_230816 {
    public long solution(int w, int h) {

        return ((long)w*h) - ((w/gcd(w,h)) + (h/gcd(w,h)) - 1) * gcd(w,h);
    }

    static long gcd(long n, long m) {
        while (m != 0) {
            long tmp = (n % m);

            n = m;
            m = tmp;
        }

        return n;
    }
}
