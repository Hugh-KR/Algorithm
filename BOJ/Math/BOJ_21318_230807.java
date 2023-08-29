package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    10:25~

    *누적합*
    (슬라이딩 윈도우?)

    난이도 최대 10억
    최악의 경우 10억 10억 10억 10억

    i번 악보의 난이도가 i+1번 악보의 난이도보다 높다면 실수
    마지막은 무조건 성공

    일단 완탐으로 풀어보자

    1차 시도 - 시간 초과
    2차 시도 - 100
 */
public class BOJ_21318_230807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 누적합 구하기
        int[] result = new int[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (arr[i-1] > arr[i]) {
                count++;
            }
            result[i] = count;
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x == y) {
                sb.append(0).append("\n");
                continue;
            }
            sb.append(result[y] - result[x]).append("\n"); // 구간합 구하기
        }

        System.out.println(sb);
    }
}
