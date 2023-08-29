package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_230319 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        sb.append(gcd(a, b)).append("\n").append(lem((a * b), gcd(a, b)));
        System.out.println(sb);
    }

    // 최대공약수
    static int gcd(int a, int b) {
        while(b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }

    // 최소공배수
    static int lem(int mul, int gcd) {
        return mul / gcd;
    }
}
