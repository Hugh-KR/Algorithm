package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1285_230429 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            int equal = 1;
            for (int j = 0; j < N; j++) {
                arr[j] = Math.abs(Integer.parseInt(st.nextToken()));
                if (min == arr[j]) {
                    equal++;
                }
                min = Math.min(min, arr[j]);
            }
            sb.append(String.format("#%d %d %d\n", i, min, equal));
        }
        System.out.println(sb);
    }
}
