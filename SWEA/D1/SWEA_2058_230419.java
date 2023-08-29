package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2058_230419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int cnt = (T / 1000) + ((T % 1000) / 100) + (((T % 1000) % 100) / 10) + (T % 10);
        System.out.println(cnt);
    }
}
