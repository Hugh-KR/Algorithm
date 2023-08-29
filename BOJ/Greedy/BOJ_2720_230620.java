package BOJ.Greedy;

import java.io.*;

public class BOJ_2720_230620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] remain = new int[]{25, 10, 5, 1};

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int[] remainCnt = new int[4];
            int c = Integer.parseInt(br.readLine());

            while (c != 0) {
                for (int i = 0; i < 4; i++) {
                    if (c >= remain[i]) {
                        remainCnt[i] += c / remain[i];
                        c %= remain[i];
                    }
                }
            }

            for (int val : remainCnt) {
                sb.append(val + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
