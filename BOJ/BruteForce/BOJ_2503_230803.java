package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    20:52~21:40
    *완전탐색*

    모든 가능성 구해서 strike, ball 비교하기
 */

class Baseball {
    String num;
    int strike;
    int ball;

    public Baseball(String num, int strike, int ball) {
        this.num = num;
        this.strike = strike;
        this.ball = ball;
    }
}

public class BOJ_2503_230803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Baseball> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            q.offer(new Baseball(num, strike, ball));
        }

        int result = 0;
        for (int x = 1; x < 10; x++) {
            for (int y = 1; y < 10; y++) {
                for (int z = 1; z < 10; z++) {
                    if (x == y || x == z || y == z) continue; // 세자리 숫자 달라야함

                    int cnt = 0;
                    for (int i = 0; i < n; i++) {
                        Baseball base = q.poll();
                        String num = base.num;
                        int strike = base.strike;
                        int ball = base.ball;

                        String poss = "";
                        poss = (poss + x) + y + z;

                        int strikeNum = 0;
                        int ballNum = 0;

                        if (num.charAt(0) == poss.charAt(0)) strikeNum++;
                        else if (num.charAt(1) == poss.charAt(0)) ballNum++;
                        else if (num.charAt(2) == poss.charAt(0)) ballNum++;

                        if (num.charAt(1) == poss.charAt(1)) strikeNum++;
                        else if (num.charAt(0) == poss.charAt(1)) ballNum++;
                        else if (num.charAt(2) == poss.charAt(1)) ballNum++;

                        if (num.charAt(2) == poss.charAt(2)) strikeNum++;
                        else if (num.charAt(0) == poss.charAt(2)) ballNum++;
                        else if (num.charAt(1) == poss.charAt(2)) ballNum++;

                        if (strike == strikeNum && ball == ballNum) cnt++;
                        q.offer(new Baseball(num, strike, ball));
                    }

                    if (cnt == n) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
