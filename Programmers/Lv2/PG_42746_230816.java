package Programmers.Lv2;
import java.util.*;

/*
    09:08~10:17

    *정렬*

    문자열 배열로 변환하여 앞뒤 비교하여 내림차순 정렬

    0 <= numbers <= 1000

    1차 시도 - 93점
    2차 시도 - 100점 (0 반례)
*/
public class PG_42746_230816 {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] strNum = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            strNum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNum, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        if (strNum[0].equals("0")) return "0"; // 내림차순 결과 첫번째 값이 0이라면 0이 가장 큰 값

        for (String str : strNum) {
            sb.append(str);
        }

        return sb.toString();
    }
}
