package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    09:11~

    *이분탐색*

    1 <= N <= 100만
    1 <= K <= 10억

    1 <= X <= 10억

    - 가능한 가장 큰 최소 값 만들기 (최대중의 최소?)

    1차 시도 - 시간 초과
    2차 시도 - 100점 (왜 10억 1?)
 */
public class BOJ_16564_230818 {
    static int n,k;
    static int[] arr;
    static long min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, arr[i]);
        }

        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long L = min;
        long R = 1000000000;
        long result = 0;

        while (L <= R) {
            long mid = (L+R)/2;

            if (levelUp(mid) <= k) {
                result = Math.max(result,mid);
                L = mid+1;
            } else {
                R = mid-1;
            }
        }

        return result;
    }

    static long levelUp(long mid) {
        long levelCnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= mid) levelCnt += (mid - arr[i]);
        }

        return levelCnt;
    }
}
