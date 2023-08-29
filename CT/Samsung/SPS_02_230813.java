package CT.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    09:17~
    (23.08.15)14:07

    *시뮬레이션*

    모든 참가자 1초당 한칸씩 움직임
    동시에 움직임
    상하좌우
    움직일 수 있는 칸이 2개 이상이라면, 상하 우선순위
    움직일 수 없는 상황이라면 움직이지 않음

    * 한칸에 2명 이상 모험자? -> 이 부분 때문에 몇일을 날림, 안 풀릴때는 문제를 잘 읽어보자

    - 각 위치 (r,c) 아래로 갈수록 r 증가, 오른쪽으로 갈수록 c증가
    - 1명 이상 참가자와 출구 포함한 가장 작은 정사각형 잡음
    - 2개 이상이라면 좌상단 r좌표 그래도 같으면 c좌표 우선순위
    - k초 반복하고 k초 전에 모든 참가자 탈출 성공하면 게임 끝
    - 게임 끝났을 때 모든 참가자들의 이동 거리 합과 출구 좌표 출력


 */
public class SPS_02_230813 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n,m;
    static int moveCnt = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) { //지도 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) * -1;
            }
        }

        for (int i = 0; i < m; i++) { //참가자 입력
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c]++;
        }

        st = new StringTokenizer(br.readLine());
        // 출구 위치 갱신하며 진행
        int exitR = Integer.parseInt(st.nextToken());
        int exitC = Integer.parseInt(st.nextToken());
        map[exitR][exitC] = -10;

        //k초 만큼 게임 진행
        for (int t = 1; t <= k; t++) {

//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= n; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            move();

            if (isFinish()) {
                break; // 종료 조건 (모두 탈출한 경우)
            }

            rotate();

//            System.out.println();
//            for (int i = 1; i <= n; i++) {
//                for (int j = 1; j <= n; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }

        sb.append(moveCnt).append("\n");
        Runners exit = findExit();
        sb.append(String.format("%d %d", exit.r, exit.c));

        System.out.println(sb);

    }

    static boolean isFinish() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
    static void move() {
        int[][] tmp = new int[n+1][n+1];
        Runners exit = findExit();

//        System.out.println(exit.r + " " + exit.c);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] < 0) {
                    tmp[i][j] = map[i][j];
                    continue;
                }
                if (map[i][j] == 0) {
                    continue;
                }

                int curDist = Math.abs(i - exit.r) + Math.abs(j - exit.c);
                int minDist = curDist;
                int minX = 0;
                int minY = 0;
                for (int idx = 0; idx < 4; idx++) {
                    int nx = i + dx[idx];
                    int ny = j + dy[idx];

                    if (!isRange(nx, ny)) continue; // 범위 벗어나면 안됨
                    if (-9 <= map[nx][ny] && map[nx][ny] <= -1) continue; // 벽이면 안됨

                    int dist = Math.abs(nx - exit.r) + Math.abs(ny - exit.c); // 출구 까지의 거리

                    if (minDist > dist) { // 출구까지 거리가 더 가까워 졌다면, 갱신
                        minDist = dist;
                        minX = nx;
                        minY = ny;
                    }
                }

                if (minDist == curDist) { // 이동할 위치 없음
                    tmp[i][j] += map[i][j];
                    continue;
                }

                moveCnt += map[i][j]; // 해당 위치의 모든 참가자들 이동

                if (map[minX][minY] == -10) { // 이동할 위치가 출구인 경우
                    continue;
                }

                tmp[minX][minY] += map[i][j]; // 참가자들의 수는 누적될 수 있다
            }
        }

        for (int i = 1; i <= n; i++) { // 임시 배열의 값 map 으로 옮김
            for (int j = 1; j <= n; j++) {
                map[i][j] = tmp[i][j];
            }
        }
    }


    static void rotate() {
        // 출구와 참가자를 포함한 회전
        // 가장 작은 정사각형의 크기 = 출구 & 참가자 (출구와 가장 가까운)

        // 1. 정사각형 크기 먼저 결정하기
        Runners exit = findExit();
        int squareSize = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] <= 0) continue;

                // 출구까지의 행과 열 거리 계산하여 큰값중 작은값 찾기
                int dist = Math.max(Math.abs(i - exit.r), Math.abs(j - exit.c));
                squareSize = Math.min(squareSize, dist);


            }
        }

        // 2. 정사각형 위치 찾기
        int Row = 0, Col = 0; // 결정된 정사각형의 좌상단 좌표
        for (int i = 1; i <= n-squareSize; i++) {
            for (int j = 1; j <= n-squareSize; j++) {

                boolean personFlag = false;
                boolean exitFlag = false;

                for (int r = i; r <= i+squareSize; r++) {
                    for (int c = j; c <= j+squareSize; c++) {
                        if (map[r][c] > 0) personFlag = true;
                        if (map[r][c] == -10) exitFlag = true;
                    }
                }

                if (personFlag && exitFlag) { // 사람과 출구를 모두 포함하는 정사각형
                    Row = i;
                    Col = j;
                    break;
                }
            }
            if (Row != 0) break;
        }

        // 3. 회전하기
        subRotate(Row,Col,squareSize);
    }

    static void subRotate(int Row, int Col, int squareSize) {
        int[][] tmp = new int[squareSize+2][squareSize+2]; // 정사각형 넣어줄 더미 배열
        int[][] rotateTmp = new int[squareSize+2][squareSize+2]; // 회전한 값 넣어줄 배열

        for (int i = Row; i <= Row+squareSize; i++) { // 더미 배열에 1,1 부터 넣기(다루기 쉬워짐)
            for (int j = Col; j <= Col+squareSize; j++) {
                tmp[i-Row+1][j-Col+1] = map[i][j];
            }
        }

        int size = squareSize+1;
        for (int i = 1; i <= size; i++) { // 더미 배열 시계방향으로 90도 돌리기
            for (int j = 1; j <= size; j++) {
                if (-9 <= tmp[i][j] && tmp[i][j] <= -1) {
                    tmp[i][j]++;
                }
                rotateTmp[j][size+1-i] = tmp[i][j];
            }
        }

        for (int i = Row; i <= Row+squareSize; i++) { // 원본 배열에 덮어 씌우기
            for (int j = Col; j <= Col+squareSize; j++) {
                map[i][j] = rotateTmp[i-Row+1][j-Col+1];
            }
        }

    }
    static Runners findExit() { // 출구위치 찾기
        Runners runners = null;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == -10) {
                    runners = new Runners(i,j);
                }
            }
        }
        return runners;
    }

    static boolean isRange(int nx, int ny) {
        return (nx > 0 && ny > 0 && nx <= n && ny <= n);
    }

    static class Runners {
        int r,c;

        public Runners(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
