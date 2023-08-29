package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9506_230312 {
    static int n;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        while(true){
            n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            sb.append(n).append(" = ");
            cnt = 0;

            if(n == -1) {
                break;
            }
            for (int i = 1; i < n; i++) {
                if(n % i == 0) {
                    cnt += i;
                    sb.append(i).append(" + ");
                }
            }
            if(cnt != n) {
                System.out.println(n + " is NOT perfect.");
            }else{
                sb.setLength(sb.length() - 3);
                System.out.println(sb.toString());
            }

        }

    }
}
