package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    11:30~

    *LIS*

    - 전깃줄이 서로 교차하지 않게 하기 위해 없애야 하는 전깃줄의 최소 개수
    - 전깃줄의 개수는 100 이하
    - 같은 위치에 두 개 이상의 전깃줄 연결될 수 없음.
    - 연결 가능한 최대 전선을 구해서 전체 전선 수 에서 빼주기
 */
public class BOJ_2565_230830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        ArrayList<Node> list = new ArrayList<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Node(a,b));
        }

        Collections.sort(list, ((o1, o2) -> {
            return o1.a - o2.a;
        }));


        // LIS
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list.get(i).b > list.get(j).b) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 내꺼하나 +1
                }
            }
        }

        System.out.println(n - Arrays.stream(dp).max().getAsInt());
//        for (int i = 0; i < n; i++) {
//            System.out.print(dp[i] + " ");
//        }
    }

    static class Node {
        int a,b;

        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
