package CT.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    09:15~

    *시뮬레이션*

    회전 정보
    x = 원판의 종류
    d = 방향 (0: 시계방향, 1: 반시계 방향)
    k = 회전하는 칸 수

    - 회전시킨 이후 원판에 수가 남아 있으면 인접하면서 숫자가 같은 수를 지움
    - 원판의 회전은 독립적
    - x의 배수일 경우 회전시킴
    - 문제의 본질은 생각보다 단순해보임
    - 최댓값 자체는 적음, 일단 편하게 구현해볼것
    - 같이 이동하는것 필요
    - m 의 끝은 처음과 인접함
    - n 은 괜찮
 */
public class SPS_06_230827 {
    static int n, m, q;
    static int[][] map;
    static int[] dr = {-1,0,1,0};
    static int[] dm = {0,1,0,-1};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 원판의 개수
        m = Integer.parseInt(st.nextToken()); // 원판 내의 숫자 개수
        q = Integer.parseInt(st.nextToken()); // 회전 횟수



        map = new int[n+1][m+1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 원판의 종류
            int d = Integer.parseInt(st.nextToken()); // 방향 (0: 시계방향, 1: 반시계 방향)
            int k = Integer.parseInt(st.nextToken()); // 회전하는 칸 수

            changeCircle(x, d, k);

            flag = false;
            // 인접한 숫자 찾기
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= m; b++) {
                    bfs(a,b);
                }
            }

            if (!flag) {
                int avg = sum / (n*m);
                for (int a = 1; a <= n; a++) {
                    for (int b = 1; b <= m; b++) {
                        if (map[a][b] != 0) {
                            if (map[a][b] > avg) map[a][b] -= 1;
                            else if (map[a][b] < avg) map[a][b] += 1;
                        }
                    }
                }
            }

        }





//        bfs(); // 인접한 숫자 찾기
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if (!visited[i][j]) bfs(i,j); // 인접한 숫자 찾기
//            }
//        }

        // 결과 출력
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(map[i][j] != 0) result += map[i][j];
            }
        }
        System.out.println(result);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 인접한 숫자 찾기
    // 배열의 끝과 끝 고려
    static void bfs(int x, int y) {
        Queue<CirclePos> q = new LinkedList<>();
        q.offer(new CirclePos(x,y)); // 최초 탐색 지점

        while (!q.isEmpty()) {
            CirclePos circlePos = q.poll();
            int a = circlePos.a;
            int b = circlePos.b;

            for (int i = 0; i < 4; i++) {
                // 배열의 끝과 끝 고려
                int na = a + dr[i];
                int nb = b + dm[i];

//                // n이 끝일 경우 처음으로
//                if (na == n+1) na = 1;
//                else if (na == 0) na = n;

                // m이 끝일 경우 처음으로
                if (nb == m+1) nb = 1;
                else if (nb == 0) nb = m;

                if (isRange(na,nb) && map[na][nb] != 0) {

                    if (map[a][b] == map[na][nb]) {
                        q.offer(new CirclePos(na,nb));
                        flag = true;
                    }
                }
            }
        }

    }

    static boolean isRange(int nr, int nm) {
        return (nr >= 1 && nm >= 1 && nr <= n && nm <= m);
    }

    static class CirclePos {
        int a,b;

        public CirclePos(int a, int b) {
            this.a = a;
            this.b = b;
        }

    }

    // 원판 회전
    static void changeCircle(int x, int d, int k) {

        for (int i = 1; i <= n; i++) {
            if (i % x == 0) {
                if (d == 0) rightRot(i, k); // 시계방향 회전
                else if (d == 1) leftRot(i, k); // 반시계방향 회전
            }
        }

    }

    // 시계방향 회전
    static void rightRot(int x, int k) {
        for (int i = 0; i < k; i++) { // k 만큼 회전
            map[x][0] = map[x][m];
            for (int j = m - 1; j >= 0; j--) {
                map[x][j + 1] = map[x][j];
            }
        }
        map[x][0] = 0;
    }

    // 반시계방향 회전
    static void leftRot(int x, int k) {
        for (int i = 0; i < k; i++) { // k 만큼 회전
            for (int j = 1; j <= m; j++) {
                map[x][j - 1] = map[x][j];
            }
            map[x][m] = map[x][0];
        }
    }
}
