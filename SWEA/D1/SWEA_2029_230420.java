package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2029_230420 {
    static int T;
    static int num = 1;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            divRemain(a, b);
        }

        System.out.println(sb);
    }

    static void divRemain(int a, int b) {
        sb.append("#" + num + " " + (a / b) + " " + (a % b)).append("\n");
        num++;
    }
}
