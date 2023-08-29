package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10430_230513 {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sb.append((A+B)%C).append("\n");
        sb.append(((A%C) + (B%C))%C).append("\n");
        sb.append((A*B)%C).append("\n");
        sb.append(((A%C) * (B%C))%C).append("\n");
        System.out.println(sb);
    }
}
