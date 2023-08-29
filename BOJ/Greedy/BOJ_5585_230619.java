package BOJ.Greedy;

import java.io.*;

public class BOJ_5585_230619 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 1000 - Integer.parseInt(br.readLine());
        int cnt = 0;
        int[] coin = new int[]{500, 100, 50, 10, 5, 1};

        for (int i = 0; i < 6; i++) {
            if (N / coin[i] > 0) {
                cnt += N / coin[i];
                N %= coin[i];
            }
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}
