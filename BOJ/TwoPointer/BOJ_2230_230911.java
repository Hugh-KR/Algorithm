package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    13:15~13:53 (38분)

    *투 포인터*

    - 수열이 주어짐
    - 주어진 수열에서 두 수를 골랐을 때(같은 수 일 수도 있음),
      그 차이가 M 이상이면서 제일 작은 경우를 구하는 프로그램을 작성하라.

    1 <= N <= 10만
    0 <= M <= 20억
    0 <= |A[i]| <= 10억

    투 포인터 사용해 절반만 탐색하는 방향으로 접근

    - 1차 시도: 시간초과
    - 2차 시도:
 */
public class BOJ_2230_230911 {
    static int n,m;
    static int[] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n]; // 수열 담을 배열

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
        }
        Arrays.sort(arr); // 오름차순 정렬

        twoPointer();

        System.out.println(result);
    }


    /*
        1 2 3 4 5
        L
        R
         R
     */

    static void twoPointer() {
        int L = 0;
        int R = 0;

        while (R < n) {

            int sub = arr[R] - arr[L];

            if (sub == m) { // m과 같으면 더 볼 필요 없음
                result = sub;
                break;
            }

            if (sub < m) {
                R++;
            } else {
                result = Math.min(result, sub);
                L++;
            }

        }
    }
}
