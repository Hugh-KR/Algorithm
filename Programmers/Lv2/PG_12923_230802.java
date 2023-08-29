package Programmers.Lv2;
import java.util.*;

/*
    09:40~
    나누어 떨어지는 소수로 나눈값?
*/
public class PG_12923_230802 {
    public List<Integer> solution(long begin, long end) {
        ArrayList<Integer> list = new ArrayList<>();

        // 소수
        for (long i = begin; i <= end; i++) {
            if (i == 1) {
                list.add(0);
                continue;
            } else {
                list.add((int)isPrime(i));
            }
        }


        return list;
    }

    // 소수말고 약수 구하기?
    static long isPrime(long num) {

        long pre = 0;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i > 10000000) { // 1000만 이상일 경우 pre 갱신하여 출력
                    pre = i;
                    continue;
                }
                return num / i;
            }
        }

        if (pre > 0) return pre;
        else return 1;
    }
}
