package BOJ.Greedy;

import java.io.*;

public class BOJ_1789_230619 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        long sum = 0;
        int cnt = 0;

        for (int i = 1; ; i++) {
            if (sum > N) break;
            sum += i;
            cnt++;
        }

        bw.write(String.valueOf(cnt - 1));
        bw.flush();

        bw.close();
        br.close();
    }
}
