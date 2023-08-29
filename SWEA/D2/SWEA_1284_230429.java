package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1284_230429 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int[] arr = new int[5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int A = arr[0] * arr[4];
            int B = 0;
            if (arr[2] >= arr[4]) {
                B = arr[1];
            } else {
                B = arr[1] + ((arr[4] - arr[2]) * arr[3]);
            }
            sb.append(String.format("#%d %d\n", i, Math.min(A, B)));
        }
        System.out.println(sb);
    }
}

