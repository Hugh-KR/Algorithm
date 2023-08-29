package Programmers.Lv3;
import java.util.*;

/*
    09:07~잠시 다음 문제로
    09:07~13:23

    s.substring() = O(n)

    1차 시도 62.7
    2차 시도 69.3
    3차 시도 90.1
    4차 시도 100

    최대길이부터 시작하면 만나자마자 반환하면 된다. (최댓값 갱신 불필요)
*/

public class PG_12904_230803 {
    public int solution(String s)
    {
        int answer = 1;
        // if (s.length() == 0) return 0;
        // if (s.length() == 1) return 1;
        // 'abcde' 결과값 1이어야 함


        for (int i = s.length(); i > 1; i--) {
            for (int j = 0; j + i <= s.length(); j++) {


                if (isPalindrome(s, j, j+i)) {
                    return ((j+i) - j);
                }
                // System.out.println(j + " " + (j+i));
                // // System.out.println(str);
                // String reverseStr = "";
                // for (int idx = str.length()-1; idx >= 0; idx--) {
                //     reverseStr += str.charAt(idx);
                // }
                // // StringBuilder sb = new StringBuilder(str);
                // if (str.equals(reverseStr)) {
                //     answer = Math.max(answer, str.length());
                // }
            }
        }

        return answer;
    }

    private static boolean isPalindrome(String str, int start, int end) {
        int length = end - start;
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i + start) != str.charAt(end - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
