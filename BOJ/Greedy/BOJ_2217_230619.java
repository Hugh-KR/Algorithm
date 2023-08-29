package BOJ.Greedy;

import java.io.*;
import java.util.Arrays;

public class BOJ_2217_230619 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];

        for (int i = 0; i < N; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, rope[i] * (N - i));
        }

        bw.write(String.valueOf(max));
        bw.flush();

        bw.close();
        br.close();
    }
}
