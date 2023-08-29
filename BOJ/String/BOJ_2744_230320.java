package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2744_230320 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            String c_Str = String.valueOf(str.charAt(i));
            if(c_Str == c_Str.toUpperCase()) {
                sb.append(c_Str.toLowerCase());
            } else {
                sb.append(c_Str.toUpperCase());
            }
        }

        System.out.println(sb);
    }
}
