package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    15:45~

    *이분탐색*

    공유기 문제의 기초?
    Lower Bound = 최솟값, 하한값
    Upper Bound = 최댓값, 상한값

    좌표 값으로 arr를 이분탐색?

    1차 시도 - 시간 초과
    2차 시도 - 시간 초과
    3차 시도 -
 */
public class BOJ_11663_230809 {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (arr[n-1] < a) {
                sb.append(0).append("\n");
                continue;
            }
            if (arr[n-1] < b) b = arr[n-1];

            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (a <= arr[j] && arr[j] <= b) cnt++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

//    static boolean binarySearch(int a, int b, int num) {
//        int L = a;
//        int R = b;
//
//        while (L <= R) {
//            int mid = (L+R)/2;
//
//            if (num > mid) {
//                L = mid+1;
//            } else if (num < mid){
//                R = mid-1;
//            }
//            if (mid == num) return true;
//        }
//
//        return false;
//    }


}
