package BOJ.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_230327 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Stack<Character> st = new Stack<>();
        int cnt = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                st.push('(');
            } else if (str.charAt(i) == ')') {
                st.pop();
                if(str.charAt(i - 1) == '(') {
                    cnt += st.size();
                } else {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
