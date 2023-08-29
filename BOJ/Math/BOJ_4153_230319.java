package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4153_230319 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[3];

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            } else if((arr[0] * arr[0]) + (arr[1] * arr[1]) == (arr[2] * arr[2])) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);

    }
}
