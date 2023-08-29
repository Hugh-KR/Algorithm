package SWEA.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_Battle174_2_230509 {
    static int T, N, Q;
    static int sum, average, cnt;
    static ArrayList<Integer> dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            dp = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dp.add(Integer.parseInt(st.nextToken()));
            }

            Q = Integer.parseInt(br.readLine());
            arr = new int[Q];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Q; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            average = 0;
            cnt = N;
            for (int j = 0; j < (arr[Q - 1]) - N; j++) {
                sum = 0;
                for (int k = j; k < cnt + j; k++) {
                    sum += dp.get(k);
                }

                average = sum / N;
                dp.add(average);
            }

            // 출력
            sb.append(String.format("#%d ", i));
            for (int k = 0; k < Q; k++) {
                sb.append(dp.get(arr[k] - 1) + " ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
