package BOJ.BinarySearch;

import java.io.*;
import java.util.*;

public class BOJ_1920_230606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int x = Integer.parseInt(st.nextToken());
            boolean ans = isExist(arr, x);
            sb.append(ans ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static boolean isExist(int[] arr, int x) {
        int L = 0;
        int R = arr.length - 1;

        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] == x) {
                return true;
            } else if (arr[mid] > x) {
                R = mid - 1;
            } else if (arr[mid] < x) {
                L = mid + 1;
            }
        }

        return false;
    }
}
