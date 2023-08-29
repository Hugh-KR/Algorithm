package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_230731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());

        long start = 0;
        long end = Integer.MIN_VALUE; // 최댓값 (20이상은 자를 수 없다)
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }


        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }

            if (m <= sum) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);
    }
}
