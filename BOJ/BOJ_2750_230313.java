package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2750_230313 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }
        Arrays.sort(arr);
        for(int x:arr){
            sb.append(x).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
