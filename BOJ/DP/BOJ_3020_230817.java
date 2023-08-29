package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    11:28~

    "누적합"
    (이모스법)

    - 이모스법을 사용하여 누적합을 통해 각 구간의 장애물 수 구하기
    - 동굴을 세로로 보고 진행
    - 첫 번째 장애물은 항상 석순
 */
public class BOJ_3020_230817 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 길이 (항상 짝수)
        int h = Integer.parseInt(st.nextToken()); // 높이

        int[] cave = new int[h];
        for (int i = 1; i <= n; i++) {
            int obst = Integer.parseInt(br.readLine());

            if (i % 2 != 0) {  // 장애물이 왼쪽에서 시작한다면
                cave[0]++;
                cave[obst]--;
            } else { // 장애물이 오른쪽에서 시작한다면
                cave[h-obst]++;
            }
        }

        int minObst = cave[0];
        int minObstCnt = 0;
        for (int i = 1; i < h ; i++) {
            cave[i] += cave[i-1];
            minObst = Math.min(minObst, cave[i]);
        }

        for (int i = 0; i < h ; i++) {
            if (minObst == cave[i]) minObstCnt++;
        }

        System.out.println(minObst + " " + minObstCnt);

    }
}
