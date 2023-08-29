package BOJ.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13305_230619 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dis = new long[N-1];
        long[] cost = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0];

        for (int i = 0; i < N - 1; i++) {

            /*
                현재 주요소가 이전 주유소의 기름값보다 쌀 경우
                minCost 갱신.
             */
            if (cost[i] < minCost) {
                minCost = cost[i];
            }

            sum += (minCost * dis[i]); // 총 비용 누적 합
        }

        bw.write(String.valueOf(sum));
        bw.flush();

        bw.close();
        br.close();
    }
}
