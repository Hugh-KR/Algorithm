package Programmers.Lv2;
import java.util.*;

/*
    21:41~08:39

    1차 시도 28.6
    2차 시도 100 (블로그 참조)

    안입은 경우를 위한 +1?
    Hash보다는 수학문제에 가까움
*/
public class PG_42578_230803 {
    public int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0) + 1);
        }

        int result = 1;
        for (String key : map.keySet()) {
            result *= (map.get(key) + 1);
        }


        return result - 1;
    }
}
