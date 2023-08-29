package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2587_230314 {
    static int sum = 0;
    static int[] arr = new int[5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum += n;
        }
        Arrays.sort(arr);
        sb.append(sum / 5).append("\n").append(arr[5/2]);

        System.out.println(sb);
    }

}
