package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    10:07~11:02

    *DP(바텀업?)*

    - LIS
    - 아이디어가 있으면 너무나 쉽게 풀 수 있는 문제
    - 매번 최대 길이 갱신해주며 진행
    - 알고리즘은 속도가 생명
    - 모든 경우에 앞에서 부터 탐색하며, 나보다 작은 친구의 dp 값을 +1 하여 비교
    - 크다면 갱신해주면서 진행
 */
public class BOJ_11053_230830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }


        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }

        }

        // 가장 긴 수열 찾기

        System.out.println(Arrays.stream(dp).max().getAsInt());
//        System.out.println(result);
    }
}
