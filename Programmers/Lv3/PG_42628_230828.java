package Programmers.Lv3;
import java.util.*;

/*
    13:04~13:34

    *우선순위큐*

    - 최초 우선순위 큐 두개 두는 방식으로 진행했으나
    - remove 사용하여 값 제거 가능한줄 몰라 Deque로 전환
    - Deque 정렬 부분 막혀 다시 우선순위큐로 복귀하여 해결
*/
public class PG_42628_230828 {
    static PriorityQueue<Integer> asc = new PriorityQueue<>();
    static PriorityQueue<Integer> desc = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        // desc.offer(1);
        // desc.offer(2);

        // System.out.println(desc);

        for (int i = 0; i < operations.length; i++) {
            StringTokenizer st = new StringTokenizer(operations[i]);
            String com = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            // System.out.println(com + " " + num);

            pro(com, num);
        }

        // System.out.println(asc);
        // System.out.println(desc);

        if (asc.isEmpty() && desc.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = desc.poll();
            answer[1] = asc.poll();
        }

        return answer;
    }

    // 명령어 따라 수행
    static void pro(String com, int num) {
        if (com.equals("I")) {
            asc.offer(num);
            desc.offer(num);
        } else if (com.equals("D")) {

            if (num == 1 && !desc.isEmpty()) {
                int removeNum = desc.poll();
                asc.remove(removeNum);
            } else if (num == -1 && !asc.isEmpty()) {
                int removeNum = asc.poll();
                desc.remove(removeNum);

            }
        }
    }
}
