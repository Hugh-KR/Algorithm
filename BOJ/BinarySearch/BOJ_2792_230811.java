package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    09:17~

    *이분탐색*

    1 <= N <= 10억
    1 <= M <= 30만
    M <= N

    가장 많은 보석을 가져간 학생이 가지고 있는 보석의 개수
    보석을 받지 못하는 학생이 있어도 됨

    L = 1
    R = 가장 많은 보석의 개수

    중간값으로 보석을 나눠준다고 가정할 때,
    보석을 받아야 하는 학생의 수가 실제 학생의 수 보다 작아야 나눠주기 가능

    보석을 나눠줄 수 있는 경우 중 최솟값 찾기
 */
public class BOJ_2792_230811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[M];

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) { // 보석 담기
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long L = 1;
        long R = max;

        long result = 0;
        while (L <= R) {
            long mid = (L+R)/2;
            long sum = 0;
            for (int i = 0; i < M; i++) {
                sum += (arr[i] / mid);
                if (arr[i] % mid != 0) {
                    sum++;
                }
            }

            if (sum <= N) {
                result = mid;
                R = mid-1;
            } else {
                L = mid+1;
            }
        }
        System.out.println(result);
    }
}
