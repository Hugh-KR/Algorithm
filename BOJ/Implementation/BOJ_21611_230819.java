package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    09:33~

    *구현"

    - N은 항상 홀수
    - 가장 왼쪽 위 (1.1)
    - 가장 오른쪽 아래 (N.N)
    - 마법 상어의 위치 ((N+1)/2,(N+1)/2)
    - 가장 처음 상어가 있는 칸을 제외한 나머지 칸에는 구슬 들어감(1번.2번.3번)
    - 같은 번호를 가진 구슬이 연속하는 칸에 있으면 '연속하는 구슬' 이라고 함.

    블리자드 마법 - 4가지 방향 1.2.3.4 로 나타냄,(상하좌우)
                d 방향으로 거리가 s 이하인 모든 칸에 얼음 파편 던져 구슬 모두 파괴
                구슬 파괴되면 빈칸이 됨, 벽은 파괴되지 않음
                달팽이 형식으로 빈칸 채움

    구슬 폭발 - 4개 이상 연속하는 구슬이 있을 때, 더 이상 폭발하는 구슬이 없을때까지 반복

    재분배 - 하나의 그룹은 두개의 구슬 A.B 로 변함,
           A = 그룹에 들어있는 구슬의 개수
           B = 그룹을 이루고 있는 구슬의 번호
           구슬이 칸의 수보다 많아 칸에 들어가지 못하는 경우 구슬 사라짐

    시전한 마법의 정보가 주어졌을 때. 1*(폭발한 1번 구슬의 개수) + 2*(폭발한 2번 구슬의 개수) + 3*(폭발한 3번 구슬의 개수) 구하기

    달팽이 펼쳐서 생각하기? (List에 담기)
 */
public class BOJ_21611_230819 {
    static int n,m;
    static int[][] map;

    // 효과적인 상하좌우 탐색위해 1부터 인덱스 시작
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,-1,1};

    static int marble_1 = 0;
    static int marble_2 = 0;
    static int marble_3 = 0;

    static ArrayList<Integer> list;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            removeMarble(d, s);
            listInit();
            marbleBlast();

        }
        System.out.println(list);
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }


    }

    static void marbleBlast() {
        int cnt = 1;
        int start = list.get(0);
        int startIdx = 0;

        ArrayList<Target> targets = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (start == list.get(i)) cnt++;
            else {
                targets.add(new Target(cnt, start, startIdx));
                start = list.get(i);
                startIdx = i;
                cnt = 1;

            }
        }

        for (int i = 0; i < targets.size(); i++) {
            Target target = targets.get(i);
            if (target.marbleCnt >= 4) {
                if (target.marble == 1) marble_1 += target.marbleCnt;
                else if (target.marble == 2) marble_2 += target.marbleCnt;
                else if (target.marble == 3) marble_3 += target.marbleCnt;

//                for (int j = target.marbleIdx; j <= target.marbleIdx + target.marbleCnt; j++) {
//                    list.remove(j);
//                }
            }
            System.out.println(target.marbleIdx + " " +target.marble + " " + target.marbleCnt);
        }
    }

    static class Target {
        int marbleCnt, marble;
        int marbleIdx;

        public Target(int marbleCnt, int marble, int marbleIdx) {
            this.marbleCnt = marbleCnt;
            this.marble = marble;
            this.marbleIdx = marbleIdx;
        }
    }

    static void removeMarble(int d, int s) {
        int sharkPosX = ((n+1)/2);
        int sharkPosY = ((n+1)/2);

        for (int i = 0; i < s; i++) {
            sharkPosX += dx[d];
            sharkPosY += dy[d];

            if (map[sharkPosX][sharkPosY] == 1) marble_1++;
            else if (map[sharkPosX][sharkPosY] == 2) marble_2++;
            else if (map[sharkPosX][sharkPosY] == 3) marble_3++;

            map[sharkPosX][sharkPosY] = -1;
        }
    }

    static void listInit() {

        visited = new boolean[n+1][n+1]; // 방문 처리
        list = new ArrayList<>();
        int printIdx = n;
        int right = 0;
        int bottom = 1;
        int top = 1;


        for (int i = (n*2)-1; i >= 0; i--) {

            for (int j = 1; j <= printIdx; j++) {
                right += top;
//                if (map[bottom][right] == -1 || map[bottom][right] == 0) continue;
                list.add(map[bottom][right]);
            }

            printIdx--;

            for (int j = 1; j <= printIdx; j++) {
                bottom += top;
//                if (map[bottom][right] == -1 || map[bottom][right] == 0) continue;
                list.add(map[bottom][right]);
            }

            top *= (-1);
        }
    }

    static boolean isRange(int nx, int ny) {
        return (nx >= 1 && ny >= 1 && nx <= n && ny <= n);
    }
}
