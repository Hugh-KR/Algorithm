package Programmers.Lv3;
import java.util.*;

/*
    13:30~14:50

    *Greedy*

    1차 시도 - 20점
    2차 시도 - 24점
    3차 시도 - 100점

    0 <= a,b <= 10만

    배열 첫번째 인덱스 내림차순, 두번째 인덱스 오름차순 정렬여 No인센티브 건너뛰고
    점수합으로 내림차순 정렬하는 우선순위큐에 규칙에 맞게 offer

    그 후 출력하면 완성 (예외처리 포함)
*/
public class PG_152995_230807 {
    static class Node {
        int a,b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int solution(int[][] scores) {
        int answer = 0;

        int wanho_x = scores[0][0];
        int wanho_y = scores[0][1];


        // 내림차순 정렬
        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });


        int pre_x = scores[0][0];
        int pre_y = scores[0][1];

        // 우선순위 큐, 점수합 내림차순 정렬
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
            if ((o1.a + o1.b) == (o2.a + o2.b)) {
                return o2.a - o1.a;
            }
            return (o2.a + o2.b) - (o1.a + o1.b);
        });

        q.offer(new Node(pre_x, pre_y));
        for (int i = 1; i < scores.length; i++) {
            if (pre_x > scores[i][0] && pre_y > scores[i][1]) { // 두 점수 모두 작을경우
                continue;
            }

            q.offer(new Node(scores[i][0], scores[i][1])); // 그게 아니라면 offer
            pre_x = scores[i][0];
            pre_y = scores[i][1];
        }

        // 석차 카운트
        int cnt = 1;
        boolean flag = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            int a = node.a;
            int b = node.b;

            if (wanho_x == a && wanho_y == b) {
                flag = false;
                break;
            }
            cnt++;
        }

        // 출력
        if (flag) return -1;
        else return cnt;
    }
}
