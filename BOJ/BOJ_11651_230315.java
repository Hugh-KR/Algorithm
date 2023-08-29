package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11651_230315 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o2, o1) -> {
           if(o2[1] == o1[1])
               return o2[0] - o1[0];
           else
               return o2[1] - o1[1];
        });

        for(int[] x:arr) {
            for(int z:x) {
                sb.append(z).append(" ");
            }
            sb.append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
