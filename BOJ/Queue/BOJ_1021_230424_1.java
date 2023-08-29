package BOJ.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021_230424_1 {
    static int N, M;
    static LinkedList<Integer> dq = new LinkedList<>();
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int removeNum = q.poll();
            if (check(removeNum)) {
                while (removeNum != dq.get(0)) {
                    dq.addLast(dq.pollFirst());
                    cnt++;
                }
            } else {
                while (removeNum != dq.get(0)) {
                    dq.addFirst(dq.pollLast());
                    cnt++;
                }
            }
            dq.remove(0);
        }
        System.out.println(cnt);

    }

    static boolean check(int a) {
        for (int i = 0; i <= dq.size() / 2; i++) {
            if (a == dq.get(i)) {
                return true;
            }
        }
        return false;
    }
}
