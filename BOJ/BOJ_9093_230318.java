package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9093_230318 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String a = br.readLine();
            String[] modStr = a.split(" ");

            for(int j = 0; j < modStr.length; j++) {
                StringBuilder sb2 = new StringBuilder(modStr[j]);
                modStr[j] = sb2.reverse().toString();
            }
            for(String x: modStr) {
                sb.append(x).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
