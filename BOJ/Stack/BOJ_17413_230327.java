package BOJ.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413_230327 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String S = br.readLine();

        boolean check = false;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '<') {
                ReversePrint(stack);
                check = true;
                sb.append(S.charAt(i));
            } else if(S.charAt(i) == '>') {
                check = false;
                sb.append(S.charAt(i));
            } else if(check) {
                sb.append(S.charAt(i));
            }

            else {
                if(S.charAt(i) == ' ') {
                    ReversePrint(stack);
                    sb.append(S.charAt(i));
                } else {
                    stack.push(S.charAt(i));
                }
            }

        }
        ReversePrint(stack);
        System.out.println(sb);
    }

    static void ReversePrint(Stack stack) {
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
