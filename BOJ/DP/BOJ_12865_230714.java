package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

/*
    09:10~
    무게 W, 가치 V
    배낭문제(knapsack)
    문제 패턴: 물건들의 최댓값 등

    이전 아이템의 가치 저장
    기존 무게에서 자신의 무게 빼는 방식으로 저장?

 */
public class BOJ_12865_230714 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1]; // 왼쪽칸 무게, 오른쪽 가치

        int[] W = new int[N+1];
        int[] V = new int[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
//            int W = Integer.parseInt(st.nextToken());
//            int V = Integer.parseInt(st.nextToken());


        }
    }
}
