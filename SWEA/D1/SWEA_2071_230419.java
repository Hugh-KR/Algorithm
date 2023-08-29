package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2071_230419 {
    static int num = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int[] arr = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            double cnt = 0;
            for (int i = 0; i < 10; i++) {
                cnt += arr[i];
            }
            sb.append("#" + num + " " + Math.round(cnt / 10)).append("\n");
            num++;
        }

        System.out.println(sb);
    }
}
