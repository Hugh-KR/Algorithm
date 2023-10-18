package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    14:17~

    **

    - 주어진 수열에서 연속된 K개의 수 선택하여 자유롭게 재배열 (주어진 수열 내에서)
    - 연산을 수행한 후, 수열에서 만들 수 있는 연속된 증가하는 부분 수열의 최대 길이.
    - 증가하는 부분수열 -> i < j

    3 <= N <= 2000
    2 <= K <= N
    1 <= Ai <= N


 */
public class BOJ_27739_230911 {
    static int n, k;
    static int[] arr;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (k == n) {
            Arrays.sort(arr);

            checkResult(arr);
            sb.append(result);
        } else {
            pro();
            sb.append(result);
        }

        System.out.println(sb);
    }

    static void pro() {
        int idx = 0;

        while (k+idx < n) {

            // 원본 배열 카피
            int[] copyArr = new int[n];
            for (int i = 0; i < n; i++) {
                copyArr[i] = arr[i];
            }

            ArrayList<Integer> subListAsc = new ArrayList<>();
            ArrayList<Integer> subListDesc = new ArrayList<>();
            for (int j = idx; j <= (k + idx); j++) { // 서브리스트에 K만큼 넣기
                subListAsc.add(copyArr[j]);
                subListDesc.add(copyArr[j]);
            }

            Collections.sort(subListAsc); // 서브리스트 오름차순 정렬
            Collections.sort(subListDesc,Collections.reverseOrder()); // 서브리스트 내림차순 정렬

            int subListAscIdx = 0;
            for (int j = idx; j <= (k + idx); j++) { // 메인배열에 서브리스트 넣기
                copyArr[j] = subListAsc.get(subListAscIdx);
                subListAscIdx++;
            }
            checkResult(copyArr); // 연속된 증가하는 부분 수열 구하기

            int subListDescIdx = 0;
            for (int j = idx; j <= (k + idx); j++) { // 메인배열에 서브리스트 넣기
                copyArr[j] = subListAsc.get(subListDescIdx);
                subListDescIdx++;
            }
            checkResult(copyArr); // 연속된 증가하는 부분 수열 구하기

            idx++;
        }
    }

    /*

        5 3
        {2 1 5} 3 4

        2 1 5
        2 5 1
        1 2 5
        1 5 2
        5 1 2
        5 2 1

    */

    static void checkResult(int[] copyArr) {
        int cnt = 1;

        for (int i = 0; i < n - 1; i++) {
            if (copyArr[i] < copyArr[i + 1]) cnt++;
            else cnt = 1;

            result = Math.max(result, cnt);
        }
    }
}
