package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12865_230823 {
    static int n,k;
    static int maxResult = Integer.MIN_VALUE;
    static ArrayList<Knapsack> list = new ArrayList<>();
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n][100001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.add(new Knapsack(w,v));
        }
//        recur(0,0,0);
        System.out.println(recur(0,0));
//        for (int[] a : dp) {
//            for (int b : a) {
//                System.out.print(b + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(maxResult);
    }


    static int recur(int idx, int w) {
        if (w > k) return Integer.MIN_VALUE;// 무개 초과하면 최솟값으로 덮음
        if (idx == n) return 0; // 모든 인덱스 탐색 완료
        if (dp[idx][w] > 0) return dp[idx][w]; // 기존에 값 있으면 가져옴

        // 선택한 경우와 선택하지 않은 경우의 비교
        dp[idx][w] = Math.max(recur(idx+1, w + list.get(idx).w) + list.get(idx).v , recur(idx+1, w));

        return dp[idx][w];
    }

    static class Knapsack {
        int w,v;

        public Knapsack(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
