package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2501_230312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int i = 1; i <= 10000; i++){
            if (n % i == 0) {
                cnt += 1;
                if(cnt == k) {
                    System.out.println(i);
                    break;
                }
            }

        }
        if (cnt < k) {
            System.out.println(0);
        }

    }
}
