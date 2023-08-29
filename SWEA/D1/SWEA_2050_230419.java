package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2050_230419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String alph = br.readLine();

        for (int i = 0; i < alph.length(); i++) {
            sb.append(alph.charAt(i) - ('A' - 1)).append(" ");
        }

        System.out.println(sb);
    }
}
