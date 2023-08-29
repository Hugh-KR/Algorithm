package Programmers.Lv2;
import java.util.*;

/*
    09:07~09:33 (26분)

    *투 포인터*

    limit이 매개변수로 주어질 때,
    모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값 return

    2명씩 밖에 못탐
    구출하지 못하는 경우는 없음

    50 50
*/

public class PG_42885_230821 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int L = 0;
        int R = people.length-1;
        while(L <= R) {
            if ((people[L] + people[R]) <= limit) {
                answer++;
                L++;
                R--;
            } else if ((people[L] + people[R]) > limit) {
                answer++;
                R--;
            }

        }


        // PriorityQueue<Integer> pq = new PriorityQueue<>();
//         for (int i = 0; i < people.length; i++) {
//             int sum = people[i];
//             for (int j = 0; j < people.length; j++) {
//                 if(i == j) continue;
//                 if (sum + people[j] > limit) {
//                     answer++:

//                 }
//                 sum += people[j];

//             }

//         }

        // int pre = pq.poll();
        // while (!pq.isEmpty()) {
        //     int now = pq.poll();
        //     if
        // }
        // System.out.println(pq);
        return answer;
    }
}
