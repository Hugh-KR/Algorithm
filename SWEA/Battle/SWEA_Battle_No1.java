package SWEA.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_Battle_No1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[10];

            int mulIdx = 1;
            while (true) {
                int mul = n * mulIdx;
                String str = String.valueOf(mul);
                char[] strIdx = str.toCharArray();
                for (int i = 0; i < strIdx.length; i++) {
                    int idx = Integer.parseInt(String.valueOf(strIdx[i]));
                    if (!visited[idx]) {
                        visited[idx] = true;
                    }
                }
                mulIdx++;

                // visited 체크
                boolean flag = true;
                for (int i = 0; i < 10; i++) {
                    if (!visited[i]) {
                        flag = false;
                    }
                }
                if (flag) break;
            }

            sb.append(String.format("#%d %d", tc, (mulIdx-1) * n )).append("\n");
        }

        System.out.println(sb);
    }
}
