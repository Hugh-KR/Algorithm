package Programmers.Lv2;
import java.util.*;

/*
    09:33~13:00

    *완전탐색*

    시소 짝꿍
    - '탑승자의 무게, 시소 축의 곱' 이 양쪽 다 같다면 시소 짝꿍이라고 함.
    - 중심으로부터 2m 3m 4m 에 하나씩 좌석 있음
    - 몸무게 모두 정수

    몸무게 주어질 때 시소 짝꿍 몇 쌍 존재하는지 구하기

    2 <= weights의 길이 <= 100000

    모든 경우 구해보기

    1차 시도 - 시간 초과
    2차 시도 -
*/

public class PG_152996_230821 {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);

        int pre = 0;
        for (int i = 0; i < weights.length-1; i++) {
            if (i > 0 && weights[i] == weights[i-1]) {
                pre--;
                answer+=pre;
                continue;
            }

            pre = 0;
            for (int j = i+1; j < weights.length; j++) {
                if (weights[i]*2 < weights[j]) break;

                else if (weights[i]*3 < weights[j]) break;
                else if (weights[i]*4 < weights[j]) break;

                    // 4 2 -> 2 1
                    // 3 2
                    // 4 3
                else if (
                        weights[i] == weights[j]     ||
                                weights[i]*2 == weights[j]   ||
                                weights[i]*3 == weights[j]*2 ||
                                weights[i]*4 == weights[j]*3
                ) pre++;

            }
            answer+=pre;
        }


        // for (Shiso shiso : list) {
        //     System.out.print(shiso.seat + " ");
        // }
        return answer;
    }

}
