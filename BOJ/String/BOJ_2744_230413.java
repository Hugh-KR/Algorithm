package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BOJ_2744_230413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if ('a' <= a && a <= 'z') {
                sb.append((char)('A' + a - 'a'));
            } else {
                sb.append((char)('a' + a - 'A'));
            }
        }

        System.out.println(sb);
    }
}
