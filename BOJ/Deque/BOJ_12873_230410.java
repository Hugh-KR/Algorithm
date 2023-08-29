package BOJ.Deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ_12873_230410 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        long beak = 1;
        while (dq.size() != 1) {

            for (int i = 0; i < (beak * beak * beak) % dq.size(); i++) {
                dq.offer(dq.pollFirst());
            }
            dq.pollLast();
            beak++;
        }

        System.out.println(dq.peek());
    }
}
