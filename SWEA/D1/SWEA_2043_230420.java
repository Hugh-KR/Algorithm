package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2043_230420 {
    static int P,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(Count(K, P));
    }

    static int Count(int start, int end) {
        int cnt = 0;

        for (int i = start; i <= end; i++) {
            cnt++;
        }

        return cnt;
    }
}
