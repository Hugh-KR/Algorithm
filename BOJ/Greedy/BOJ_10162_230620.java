package BOJ.Greedy;

import java.io.*;
import java.util.Arrays;

public class BOJ_10162_230620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /*
         * '초'로 주어짐
         * A:5분(300초), B:1분(60초), C:10초
         */
        int T = Integer.parseInt(br.readLine());

        int[] button = new int[]{300, 60, 10};
        int[] result = new int[3];

        if (T % 10 != 0) {
            sb.append(-1);
        } else {
            for (int i = 0; i < 3; i++) {
                if (T >= button[i]) {
                    result[i] += T / button[i];
                    T %= button[i];
                }
            }

            sb.append(result[0] + " " + result[1] + " " + result[2]);
        }


        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
