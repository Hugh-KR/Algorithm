package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2070_230419 {
    static int num = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a < b) {
                sb.append("#" + num + " " + "<").append("\n");
            } else if (a > b) {
                sb.append("#" + num + " " + ">").append("\n");
            } else {
                sb.append("#" + num + " " + "=").append("\n");
            }
            num++;
        }

        System.out.println(sb);
    }
}
