package Programmers.Lv2;
import java.util.*;

/*
    17:11~17:20
    * Hash *

    1차 시도 100
*/
public class PG_42576_230802 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for (String val : participant) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        for (String val : completion) {
            map.put(val, map.getOrDefault(val, 0) - 1);
        }

        for (String val : participant) {
            if (map.get(val) == 1) {
                answer = val;
            }
        }

        return answer;
    }
}
