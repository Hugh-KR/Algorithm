package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class BOJ_1427_230315 {
    static LinkedList<Integer> list = new LinkedList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String sn = Integer.toString(n);

        for(int i = 0; i < sn.length(); i++) {
            list.add(Integer.parseInt(String.valueOf(sn.charAt(i))));
        }
        Collections.sort(list, (o1, o2) -> o2 - o1);

        for(int x: list){
            sb.append(x);
        }
        System.out.println(sb);

    }
}
