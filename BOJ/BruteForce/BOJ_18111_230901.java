package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    13:56~14:35(39분)

    *브부트포스*

    - 블록 넣는 비용 2
    - 꺼내서 두는 비용 1

    - 1 <= M,N <= 500
    - B = 현재 가지고 있는 블록 <= 1000만

    - 땅의 높이는 256블록을 초과할 수 없음, 음수가 될 수 없음.

    * 땅에 높이를 모두 동일하게 만드는 최소 시간
    * 시간과 땅의 높이 출력
 */
public class BOJ_18111_230901 {
    static int n,m,b;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static int minTime = Integer.MAX_VALUE;
    static int hight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
            }
        }
        pro();

        System.out.println(minTime + " " + hight);

    }

    static void pro() {
        for (int a = min; a <= max; a++) {
            int cost = 0; // 걸린 시간
            int block = b; // 사용한 블록

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == a) continue;

                    if (map[i][j] > a) cost += ((map[i][j] - a) * 2); // 복수의 블록을 옮길 수 도 있음
                    else cost +=  a - map[i][j];

                    block += (map[i][j] - a);
                }
            }

            if (block >= 0 && minTime >= cost) { // 블록의 수 0 이상 양수이고 시간 적게 드는 경우
                hight = a;
                minTime = cost;
            }

        }
    }
}
