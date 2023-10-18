package CT.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    09:10~

    *시뮬레이션*

    * 토끼들의 점수를 건 경주
    - 경주 시작 준비
        각 토끼에게는 고유한 번호, 한번 움직일 시 꼭 이동해야 하는 거리도 정해져 있음
        i번 토끼의 고유번호는 pid, 이동해야 하는 거리는 d, 처음 토끼들은 전부 (1행 1열)

    - 경주 진행
        가장 우선순위 높은 토끼 뽑아 멀리 보내줌 (K번 반복)
        우선 순위의 순서
        (현재까지 총 점프 횟수가 적은 토끼 > 행 + 열 작은 토끼 > 행 번호 작은 토끼 > 열 번호 작은 토끼 > 고유 번호 작은 토끼)
        첫 번째 우선순위가 높은 토끼가 한마리 뿐이면 바로 결정, 동률이면 두 번째 우선순위 ...
        우선순위 가장 높은 토끼 결정 되면 상하좌우 d 만큼 이동했을 때 위치 구함, 이때 이동하는 도중 격자 벗어나면 방향 반대로 바꿈
        이렇게 구해진 4개 위치 중 (행+열 > 행 > 열) 순으로 우선순위 두고, 가장 높은 곳으로 토끼 이동
        이 칸의 위치 (r,c) 라고 했을 떄 i번 토끼 제외한 나머지 토끼 전부 (r+c) 만큼 점수 동시에 얻음

        이렇게 K번 반복하고 동일한 토끼 여려번 선택되는것 가능

        K번 턴이 모두 진행된 직후에는 우선순위에 따라 가장 높은 토끼에게 점수 S 더해줌 (K번 동안 한번이하도 뽑혔어야함)

    - 이동거리 변경
        고유번호가 pid 인 토끼의 이동거리를 L배 해줌.
        단, 계산 도중 특정 토끼의 이동거리 10억 넘는 일 발생하지 않음

    - 최고의 토끼 선정
        각 토끼가 모든 경주를 진행하며 얻은 점수 중 가장 높은 점수 출력

    * Q번에 걸쳐 명령을 순서대로 진행

    입력 값이 까다로운 문제인듯
    우선순위 큐

 */
public class SPS_07_230902 {
    static int q;
    static int com,n,m,p;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int score = 0;
    static int bestRabbit = Integer.MIN_VALUE; // 가장 높은 점수 가진 토끼
    static PriorityQueue<Rabbits> pq = new PriorityQueue<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        q = Integer.parseInt(br.readLine());


        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            com = Integer.parseInt(st.nextToken());

            if (com == 100) init();
            if (com == 200) pro();
            if (com == 300) changeDist();
            if (com == 400) selectBestRabbit();

            System.out.println(pq);
        }


        System.out.println(bestRabbit);

    }

    static void init() {
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            int pid = Integer.parseInt(st.nextToken()); // 고유번호 (최댓값 1000만)
            int di = Integer.parseInt(st.nextToken()); // 이동해야 하는 거리 (최댓값 10억)

            pq.offer(new Rabbits(1,1,pid,di,0,0)); // 시작 지점(1행 1열) 에 토끼 넣음
        }
    }

    // 경주 진행
    static void pro() { // 핵심 로직
        int k = Integer.parseInt(st.nextToken()); // 라운드 횟수
        int s = Integer.parseInt(st.nextToken());
        ArrayList<Rabbits> winner = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Rabbits now = pq.poll();
//            PriorityQueue<JumpPos> jumpPos = new PriorityQueue<>();

            // 토끼를 위로 이동시킵니다.
            Rabbits upRabbit = getUpRabbit(now, now.di);
            // 지금까지의 도착지들보다 더 멀리 갈 수 있다면 도착지를 갱신합니다.
            if(cmp(now, upRabbit)) now = upRabbit;


            // 토끼를 아래로 이동시킵니다.
            Rabbits downRabbit = getDownRabbit(now, now.di);
            // 지금까지의 도착지들보다 더 멀리 갈 수 있다면 도착지를 갱신합니다.
            if(cmp(now, downRabbit)) now = downRabbit;


            // 토끼를 왼쪽으로 이동시킵니다.
            Rabbits leftRabbit = getLeftRabbit(now, now.di);
            // 지금까지의 도착지들보다 더 멀리 갈 수 있다면 도착지를 갱신합니다.
            if(cmp(now, leftRabbit)) now = leftRabbit;


            // 토끼를 오른쪽으로 이동시킵니다.
            Rabbits rightRabbit = getRightRabbit(now, now.di);
            // 지금까지의 도착지들보다 더 멀리 갈 수 있다면 도착지를 갱신합니다.
            if(cmp(now, rightRabbit)) now = rightRabbit;

//            System.out.println(jumpPos);

//            for (int idx = 0; idx < 4; idx++) { // 우선순위 높은 방향으로 움직임 -> 상하좌우 다 넣어줌
//
//
//                int nx = ((now.x + (dx[idx]*now.di)) % n) + 1;
//                int ny = ((now.y + (dy[idx]*now.di)) % m) + 1;
//
//
//                if (isRange(nx,ny)) {
//                    jumpPos.offer(new JumpPos(nx,ny));
//                }
//            }

//            JumpPos jump = jumpPos.poll(); // 이동할 위치 (가장 높은)
//
//            now.x = jump.x;
//            now.y = jump.y;
            now.cnt += 1;
            now.score -= (now.x + now.y);

            // 현재 토끼 제외 나머지 토끼는 (r+c) 점수를 동시에 얻어야 함
            score += (now.x + now.y); // 점수 쌓고 현재 토끼 점수는 낮춤 -> 한번에 더해서 원하는 값 출력

            winner.add(now);
            pq.offer(now); // 다시 넣어줌(갱신)
        }
        // 가장 우선순위 높은 토끼에게 점수 증정, 과정 마침
//        Collections.sort(winner, ((o1, o2) -> {
//            if ((o1.x + o1.y) != (o2.x + o2.y)) return (o2.x + o2.y) - (o1.x + o1.y);
//            if (o1.x != o2.x) return o2.x - o1.x;
//            if (o1.y != o2.y) return o2.y - o1.y;
//            return o2.pid - o1.pid;
//        }));

        Rabbits bonusRabbit = new Rabbits(0,0,0,0,0,0);
        for (Rabbits r : winner) {
            if (cmp(bonusRabbit, r)) {
                bonusRabbit = r;
            }
        }


        bonusRabbit.score += s;
        inputWinner(bonusRabbit);// 높은친구 갱신해서 다시 넣어줘야함

//        System.out.println(k + " " + s);
    }

    // 가장 긴 위치를 판단하기 위해 정렬함수를 하나 더 만들어줍니다.
    public static boolean cmp(Rabbits a, Rabbits b) {
        if(a.x + a.y != b.x + b.y) return a.x + a.y < b.x + b.y;
        if(a.x != b.x) return a.x < b.x;
        if(a.y != b.y) return a.y < b.y;
        return a.pid < b.pid;
    }

    // 토끼를 위로 이동시킵니다.
    public static Rabbits getUpRabbit(Rabbits now, int dis) {

        dis %= 2 * (n - 1);

        if(dis >= now.x - 1) {
            dis -= (now.x - 1);
            now.x = 1;
        }
        else {
            now.x -= dis;
            dis = 0;
        }

        if(dis >= n - now.x) {
            dis -= (n - now.x);
            now.x = n;
        }
        else {
            now.x += dis;
            dis = 0;
        }

        now.x -= dis;

        return now;
    }

    // 토끼를 아래로 이동시킵니다.
    public static Rabbits getDownRabbit(Rabbits now, int dis) {

        dis %= 2 * (n - 1);

        if(dis >= n - now.x) {
            dis -= (n - now.x);
            now.x = n;
        }
        else {
            now.x += dis;
            dis = 0;
        }

        if(dis >= now.x - 1) {
            dis -= (now.x - 1);
            now.x = 1;
        }
        else {
            now.x -= dis;
            dis = 0;
        }

        now.x += dis;

        return now;
    }

    // 토끼를 왼쪽으로 이동시킵니다.
    public static Rabbits getLeftRabbit(Rabbits now, int dis) {

        dis %= 2 * (m - 1);

        if(dis >= now.y - 1) {
            dis -= (now.y - 1);
            now.y = 1;
        }
        else {
            now.y -= dis;
            dis = 0;
        }

        if(dis >= m - now.y) {
            dis -= (m - now.y);
            now.y = m;
        }
        else {
            now.y += dis;
            dis = 0;
        }

        now.y -= dis;

        return now;
    }

    // 토끼를 오른쪽으로 이동시킵니다.
    public static Rabbits getRightRabbit(Rabbits now, int dis) {

        dis %= 2 * (m - 1);

        if(dis >= m - now.y) {
            dis -= (m - now.y);
            now.y = m;
        }
        else {
            now.y += dis;
            dis = 0;
        }

        if(dis >= now.y - 1) {
            dis -= (now.y - 1);
            now.y = 1;
        }
        else {
            now.y -= dis;
            dis = 0;
        }

        now.y += dis;

        return now;
    }

    static void inputWinner(Rabbits win) {
        ArrayList<Rabbits> list = new ArrayList<>();

        while (!pq.isEmpty()) {
            Rabbits r = pq.poll();
            if (r.pid == win.pid) {
                r.score = win.score;
            }
            list.add(r);
        }

        // 거리정보 수정하고 다시 넣기
        for (Rabbits r : list) {
            pq.offer(r);
        }
    }


    // 현재 토끼 제외 나머지 토끼는 (r+c) 점수를 동시에 얻어야 함
    static void addScore(int score) {
        ArrayList<Rabbits> list = new ArrayList<>();

        // 비우면서 점수 추가
        while (!pq.isEmpty()) {
            Rabbits r = pq.poll();
            r.score += score;
            list.add(r);
        }

        // 거리정보 수정하고 다시 넣기
        for (Rabbits r : list) {
            pq.offer(r);
        }
    }


    // 이동거리 변경
    static void changeDist() {
        int pid_t = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); // pid_t 토끼 이동거리 곱하기 (최댓값 10억)

        ArrayList<Rabbits> list = new ArrayList<>();

        // 비우면서 일치하는 pid에 점수 추가
        while (!pq.isEmpty()) {
            Rabbits r = pq.poll();
            if (r.pid == pid_t) {
                r.di *= L;
            }
            list.add(r);
        }

        // 거리정보 수정하고 다시 넣기
        for (Rabbits r : list) {
            pq.offer(r);
        }

//        System.out.println(pid_t + " " + L);
    }

    // 최고의 토끼 선정
    static void selectBestRabbit() {
        int[][] map = new int[n+1][m+1];

        while (!pq.isEmpty()) {
            Rabbits r = pq.poll();
            map[r.x][r.y] += 1;
            bestRabbit = Math.max(bestRabbit, (r.score + score));
        }

        for (int[] a : map) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }




    static boolean isRange(int nx, int ny) {
        return (nx >= 1 && ny >= 1 && nx <= n && ny <= m);
    }


    static class JumpPos implements Comparable<JumpPos>{


        int x,y;

        public JumpPos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(JumpPos o) {
            if ((this.x + this.y) != (o.x + o.y)) return (o.x + o.y) - (this.x + this.y);
            if (this.x != o.x) return o.x - this.x;
            return o.y - this.y;
        }

        @Override
        public String toString() {
            return "JumpPos{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


    static class Rabbits implements Comparable<Rabbits>{


        int x,y;
        int pid,di,cnt,score;

        public Rabbits(int x,int y, int pid, int di, int cnt, int score) {
            this.x = x;
            this.y = y;
            this.pid = pid;
            this.di = di;
            this.cnt = cnt;
            this.score = score;
        }


        @Override
        public int compareTo(Rabbits o) {
            if (this.cnt == o.cnt) {
                if ((this.x + this.y) == (o.x + o.y)) {
                    if (this.x == o.x) {
                        if (this.y == o.y) {
                            return this.pid - o.pid;
                        }
                        return this.y - o.y;
                    }
                    return this.x - o.x;
                }
                return (this.x + this.y) - (o.x + o.y);
            }
            return this.cnt - o.cnt;
        }

        @Override
        public String toString() {
            return "Rabbits{" +
                    "x=" + x +
                    ", y=" + y +
                    ", pid=" + pid +
                    ", di=" + di +
                    ", cnt=" + cnt +
                    ", score=" + score +
                    '}';
        }
    }


}
