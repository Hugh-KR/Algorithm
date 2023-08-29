package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    20:43~20:49

    *완전탐색*
    (직관적으로 풀어보기)

    x 와 y -999~999 까지 들어갈 수 있음
 */
public class BOJ_19532_230803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if ((a*x)+(b*y) == c && (d*x)+(e*y) == f) {
                    System.out.println(x + " " + y);
                    break;
                }
            }
        }
    }
}
