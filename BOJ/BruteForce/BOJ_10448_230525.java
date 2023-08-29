package BOJ.BruteForce;

import java.io.*;
import java.util.ArrayList;

public class BOJ_10448_230525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i <= 1000; i += cnt) {
            list.add(i);
            cnt++;
        }

        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            int K = Integer.parseInt(br.readLine());
            boolean[] isSumOfTriangle = new boolean[1001];
            int flag = 0;

            // 2개 먼저 더해봄.
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i) + list.get(j) < K) {
                        isSumOfTriangle[list.get(i) + list.get(j)] = true;
                    }
                }
            }

            // 나머지 하나 더해서 K 확인
            for (int i = 1; i < K; i++) {
                if (!isSumOfTriangle[i]) continue;
                for (int j = 0; j < list.size(); j++) {
                    if (i + list.get(j) == K) {
                        flag = 1;
                        break;
                    }
                }
            }
            sb.append(flag).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
