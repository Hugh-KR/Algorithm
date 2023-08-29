package BOJ.Greedy;

import java.io.*;
import java.util.Arrays;

public class BOJ_10610_230620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[] numCntArr = new int[10];
        long total = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = Integer.parseInt(str.substring(i, i+1));
            numCntArr[num] += 1;
            total += num;
        }

        if (total % 3 != 0 || !str.contains("0")) {
            System.out.println(-1);
            return;
        }

        for (int i = 9; i >= 0; i--) {
            while (numCntArr[i] > 0) {
                sb.append(i);
                numCntArr[i]--;
            }
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
