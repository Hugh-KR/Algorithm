package BOJ.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_230317 {

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            sb.append(VPS(br.readLine())).append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }

    static String VPS(String n) {
        Stack<String> stack = new Stack<>();
        for(int j = 0; j < n.length(); j++) {
            if(n.charAt(j) == '(') {
                stack.push("(");
            } else if (stack.isEmpty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }

    }
}

