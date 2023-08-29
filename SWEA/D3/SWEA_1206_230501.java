package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1206_230501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 0;

            // 이전 2개
            int pre1 = list.get(0);
            int pre2 = list.get(1);
            for (int j = 2; j < list.size() - 2; j++) {

                // 앞 2개
                int front1 = list.get(j + 1);
                int front2 = list.get(j + 2);

                // 조건 설정
                if (pre1 < list.get(j) && pre2 < list.get(j) && list.get(j) > front1 && list.get(j) > front2) {
                    int max = Math.max(Math.max(pre1, pre2), Math.max(front1, front2));
                    cnt += (list.get(j) - max);
                }

                // 이전 갱신
                pre1 = list.get(j - 1);
                pre2 = list.get(j);
            }
            sb.append(String.format("#%d %d\n", i, cnt));
        }
        System.out.println(sb);
    }
}
