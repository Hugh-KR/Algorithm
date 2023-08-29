package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9093_230316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] modStr = str.split(" ");
            for(String x:modStr) {
                StringBuilder reverseSb = new StringBuilder(x);
                sb.append(reverseSb.reverse()).append(" ");
            }
            sb.append("\n");

        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}

