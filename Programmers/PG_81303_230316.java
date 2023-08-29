package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class PG_81303_230316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] arr = new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n, 2, arr));

    }

    static String solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append("O");
        }
        Stack<Integer> removeS = new Stack<>();
        for(String x:cmd) {

            char c = x.charAt(0);
            if(c == 'U') {
                k -= Integer.parseInt(x.substring(2));

            }else if(c == 'D') {
                k += Integer.parseInt(x.substring(2));

            }else if(c == 'C') {
                removeS.push(k);
                sb.setCharAt(k,'X');

                if(k == sb.length()) {
                    k -= 1;
                }
            }else if(c == 'Z') {
                sb.setCharAt(removeS.pop(), 'O');
            }
        }
        return sb.toString();
    }
}
