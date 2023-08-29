package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2503_230822 {
    static int n;
    static int result = 0;
    static ArrayList<Baseball> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            list.add(new Baseball(num, strike, ball));
//            playGame(0,0,0, list.get(i));
        }

        playGame(100);
        System.out.println(result);

    }

    static void playGame(int start) {

        if (start == 1000) return;
        String str = Integer.toString(start);
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            Baseball baseball = list.get(i);
            String num = baseball.num;
            int strike = 0;
            int ball = 0;

            if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') break;
            if (str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2)) break;

            if (num.charAt(0) == str.charAt(0)) strike++;
            else if (num.charAt(1) == str.charAt(0)) ball++;
            else if (num.charAt(2) == str.charAt(0)) ball++;

            if (num.charAt(1) == str.charAt(1)) strike++;
            else if (num.charAt(0) == str.charAt(1)) ball++;
            else if (num.charAt(2) == str.charAt(1)) ball++;

            if (num.charAt(2) == str.charAt(2)) strike++;
            else if (num.charAt(0) == str.charAt(2)) ball++;
            else if (num.charAt(1) == str.charAt(2)) ball++;

            if (baseball.strike == strike && baseball.ball == ball) cnt++;
        }


//        System.out.println(cnt);
        if (cnt == n) {
            result++;
        }

        playGame(start + 1); // 하나씩 올림
    }

    static class Baseball {
        String num;
        int strike, ball;

        public Baseball(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
