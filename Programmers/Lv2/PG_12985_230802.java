package Programmers.Lv2;
import java.util.*;

/*
    2^20 = 1,050,000

    2차 시도 94.1
    3차 시도 100

    a, b를 억지로 바꾸지 말것
*/
public class PG_12985_230802 {
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        // if (b % 2 == 0 && a == b-1) return 1;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (n != 1) {
            int x = q.poll();
            int y = q.poll();

            if (x == a && y == b || x == b && y == a) break;
            else {
                if (y == a || y == b) q.offer(y);
                else q.offer(x);
            }

            if (q.size() == n/2) {
                n/=2;
                answer++;
            }
        }

        return answer;
    }
}
