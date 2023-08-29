package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795_230323 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr_A = new int[a];
            for(int j = 0; j < a; j++) {
                arr_A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int[] arr_B = new int[b];
            for(int j = 0; j < b; j++) {
                arr_B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr_B);

            int sum = 0;
            for(int k = 0; k < arr_A.length; k++) {
                sum += BinarySearch(arr_A[k], arr_B);
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }


    static int BinarySearch(int key, int[] arr) {
        int cnt = 0;
        int L = 0;
        int R = arr.length - 1;

        while(L <= R) {

            int mid = (L + R) / 2;
            if(key > arr[mid]) {
                cnt = mid + 1;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return cnt;
    }
}
