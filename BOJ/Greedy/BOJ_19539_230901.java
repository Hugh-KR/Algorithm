package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    13:39~14:54

    *그리디?*

    * 초기 높이는 모두 0

    - 1만큼 성장 시키는 경우
    - 2만큼 성장 시키는 경우
    - 3만큼 성장 시키는 경우
    - 백트래킹 경우의 수 탐색? -> n 10만 시간초과 날지도 X

    - 한번에 소모되는 물의 수 -3, 전체 나무의 갯수 3으로 나눠 져야함
    - 홀수 나무의 갯수가 3으로 나눈 몫 보다 많으면 안됨 ->
    - 물 뿌리개 동시 사용

 */
public class BOJ_19539_230901 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalHight = 0;
        int oddCnt = 0;
        for (int i = 0; i < n; i++) {
            int tree = Integer.parseInt(st.nextToken());

            totalHight += tree;
            if (tree % 2 == 1) oddCnt++;
        }

        // 1. 전체 나무의 갯수 3으로 나눠 져야함 -> 3씩 줄어듬
        // 2. 홀수 나무의 갯수가 3으로 나눈 몫 보다 많으면 안됨 -> 물뿌리개는 동시에 사용돼야함
        if (totalHight % 3 == 0 && oddCnt <= (totalHight / 3)) sb.append("YES");
        else sb.append("NO");

        System.out.println(sb);
    }
}
