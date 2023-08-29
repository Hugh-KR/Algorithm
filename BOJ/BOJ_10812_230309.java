package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_10812_230309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int i = 1; i < TC + 1; i++){
            int a = Integer.parseInt(br.readLine());
            System.out.println("#" + i + " " + a * a);

        }
    }
}
