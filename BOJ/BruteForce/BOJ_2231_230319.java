package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231_230319 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str_n = br.readLine();
        int n = Integer.parseInt(str_n);

        int result = 0;
        for(int i = (n - (str_n.length() * 9)); i < n; i++) {
            int num = i;
            int sum = 0;

            while(num != 0) {
                sum += num % 10;
                num /= 10;
            }

            if(sum + i == n) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
