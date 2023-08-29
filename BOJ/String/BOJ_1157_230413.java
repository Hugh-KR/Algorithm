package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157_230413 {
    static int[] arr = new int[26];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            arr[(int)(str.charAt(i)) - 97] += 1;
        }

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                idx = i;
            }
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                cnt++;
            }
        }

        if (cnt >= 2) {
            System.out.println("?");
        } else {
            System.out.println((char)(idx + 'A'));
        }

    }
}
