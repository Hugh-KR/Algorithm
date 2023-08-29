package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15727_230520 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result;
        if (N % 5 == 0) {
            result = N / 5;
        } else {
            result = (N / 5) + 1;
        }

        System.out.println(result);
    }
}
