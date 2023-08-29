package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_230316 {
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push": int num = Integer.parseInt(st.nextToken());
                            stack.push(num);
                            break;
                case "pop": if(!stack.isEmpty()) {
                            sb.append(stack.pop()).append("\n");
                            } else {
                            sb.append(-1).append("\n");
                            }
                            break;
                case "size": sb.append(stack.size()).append("\n");
                            break;
                case "empty": if(stack.isEmpty()) {
                            sb.append(1).append("\n");
                            } else {
                            sb.append(0).append("\n");
                            }
                            break;
                case "top": if(!stack.isEmpty()) {
                            sb.append(stack.peek()).append("\n");
                            } else {
                            sb.append(-1).append("\n");
                            }
                            break;
            }

        }
        System.out.println(sb);
    }
}
