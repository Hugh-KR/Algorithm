package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3028_230402 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String com = br.readLine();

        System.out.println(Change(com));
    }

    static int Change(String com) {
        int ball = 1;
        for(int i = 0; i < com.length(); i++) {
            switch (com.charAt(i)) {
                case 'A':
                    if (ball == 1) ball = 2;
                    else if (ball == 2) ball = 1;
                    break;
                case 'B':
                    if (ball == 2) ball = 3;
                    else if (ball == 3) ball = 2;
                    break;
                case 'C':
                    if (ball == 1) ball = 3;
                    else if (ball == 3) ball = 1;
                    break;
            }
        }
        return ball;
    }
}
