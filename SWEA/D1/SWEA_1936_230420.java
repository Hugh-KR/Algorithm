package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1936_230420 {
    static int A,B;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        rockPaperScissors(A, B);
        System.out.println(sb);
    }

    static void rockPaperScissors(int A, int B) {

        if (A > B && A - B == 1) {
            sb.append("A");
        } else if (A > B && A - B == 2) {
            sb.append("B");
        }

        if (B > A && B - A == 1) {
            sb.append("B");
        } else if (B > A && B - A == 2) {
            sb.append("A");
        }
    }
}
