package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654_230412 {
    static int K,N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        System.out.println(UpperBound());
    }

    static long UpperBound() {

        long min = 0;
        long max = arr[K - 1] + 1;

        while (min < max) {
            long mid = (min + max) / 2;

            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                cnt += (arr[i] / mid);
            }

            if (cnt < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min - 1;
    }
}
