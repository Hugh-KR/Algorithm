package Programmers.Lv2;
import java.util.*;

/*
    19:33~20:00
    접두사 검사
    * 이게 해시? *

    접두어 = 시작하는 부분

    1차 시도 75.0
    2차 시도 83.3
    3차 시도 100
*/
public class PG_42577_230802 {
    public boolean solution(String[] phone_book) {

        /*
            Hash 풀이
        */

        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();
        for (String phone_num : phone_book) {
            map.put(phone_num, 1);
        }

        for (String phone_num : phone_book) {
            for (int i = 0; i < phone_num.length(); i++) {
                String nums = phone_num.substring(0,i);
                if (map.containsKey(nums)) return false;
            }
        }

        return answer;

        /*
            배열 정렬 풀이
        */
//         boolean answer = true;
//         Arrays.sort(phone_book);

//         for (int i = 0; i < phone_book.length-1; i++) {
//             if (phone_book[i+1].startsWith(phone_book[i])) {
//                 answer = false;
//                 break;
//             }
//         }

//         return answer;

    }
}
