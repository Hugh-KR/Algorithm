package CT.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    09:10~

    *BFS*
    (주로 최단 경로에 사용)

    4 <= N M <= 10
    1 <= K <= 1000
    0 <= 공격력 <= 5000

    - 하나의 턴에 4가지 공격
    - 부서지지 않은 포탑 1개가 된다면 그 즉시 종료

    1. 가장 약한 포탑 공격자로 선정
    2. 위에서 선정된 공격자는 자신을 제외한 가장 강한 포탑을 공격
    3. 공격을 받아 공격력 0 이하 된 포탑은 부서짐
    4. 공격이 끝났으면, 부서지지 않은 포탑 중 공격과 무관했던 포탑 공격력 1씩 증가 (공격자 아니고, 피해도 입지 않음)

    매번 x y 갱신하며 진행

    공격 수단
    레이저 - 최단 경로로 공격, 경로 존재하지 않으면 포탄 공격, 경로 2개 이상이라면, 우/하/좌/상 우선순위 경로
            레이저 경로에 있는 포탑도 공격력의 절반 만큼 피해 받음
    포탄 -
 */


class Node implements Comparable<Node> {
    int x,y;
    int power;
    int attackCnt;

    public Node (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node (int x, int y, int power, int attackCnt) {
        this.x = x;
        this.y = y;
        this.power = power;
        this.attackCnt = attackCnt;
    }

    @Override
    public int compareTo(Node o) {
        if (this.power == o.power) { // 공격력이 같다면
            if (this.attackCnt == o.attackCnt) { // 공격 시점 같다면
                if ((this.x + this.y) == (o.x + o.y)) { // 행열 합 같다면
                    return o.y - this.y; // 열기준 내림차순
                }
                return (o.x + o.y) - (this.x + this.y); // 행열 합 내림차순
            }
            return o.attackCnt - this.attackCnt; // 공격 시점 내림차순
        }

        return this.power - o.power; // 기본적으로 공격력 기준 오름차순
    }


}
public class SPS_01_230812 {
    static int n,m;
    static int[][] graph;
    static int[][] attack;
    static boolean[][] effect;

    // 우.하.좌.상
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    //폭탄 공격 - 우.하.좌.상.대각선
    static int[] bdx = {0,1,0,-1,1,1,-1,-1};
    static int[] bdy = {1,0,-1,0,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        attack = new int[n][m];

        for (int i = 0; i < n; i++) { // 그래프 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 1; t <= k; t++) { //k번 공격 진행, 레이저 공격 시도하고 그게 안된다면 포탄 공격

            if (turretCnt()) {
                break;
            }
//            attackerSelection();
//            graph[attackerX][attackerY] += (n+m);
//
//            enemySelection();
//            System.out.println(enemyX + " " + enemyY + " " + graph[enemyX][enemyY]);\

            effect = new boolean[n][m];
            ArrayList<Node> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] != 0) {
                        list.add(new Node(i, j, graph[i][j], attack[i][j]));
                    }
                }
            }

            Collections.sort(list);

            Node start = list.get(0);
            Node end = list.get(list.size() - 1);

            graph[start.x][start.y] += (n+m); //공격력 증가
            effect[start.x][start.y] = true; //영향받은 친구 표시
            attack[start.x][start.y] = t; //공격시점 갱신

            if (!laserAttack(start, end)) { //공격 진행
                bombAttack(start,end);
            }

            //부서진 포탑 처리
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] < 0) {
                        graph[i][j] = 0;
                    }
                }
            }

            //포탑 정비
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!effect[i][j] && graph[i][j] != 0) {
                        graph[i][j]++;
                    }
                }
            }


        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, graph[i][j]);
            }
        }

        System.out.println(max);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    // 레이저 공격
    // BFS = 주로 최단 경로에 사용
    static boolean laserAttack(Node attacker, Node enemy) {

        Node[][] routeArr = new Node[n][m];
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        visited[attacker.x][attacker.y] = true;
        q.offer(new Node(attacker.x, attacker.y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int nx = (n + x + dx[i]) % n;
                int ny = (m + y + dy[i]) % m;

                if (!visited[nx][ny] && graph[nx][ny] != 0) {
                    q.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                    routeArr[nx][ny] = new Node(x, y);
                }
            }
        }

        if (!visited[enemy.x][enemy.y]) { //타겟까지 갈 수 없음
            return false;
        }
////        System.out.println("성공");
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (routeArr[i][j] != null) {
//                    System.out.println(i + " " + j + " " + routeArr[i][j].x + " " + routeArr[i][j].y);
//                }
//            }
//        }

        int x = enemy.x;
        int y = enemy.y;

        while (x != attacker.x || y != attacker.y) {
            int power = graph[attacker.x][attacker.y] / 2;
            if (x == enemy.x && y == enemy.y) { //타켓 찾은경우 풀파워로 때림
                power = graph[attacker.x][attacker.y];
            }

            graph[x][y] -= power;
            effect[x][y] = true; //영향 받은 친구 표시

            //역추적
            Node node = routeArr[x][y]; //한번에 쓰면 바뀜
            x = node.x;
            y = node.y;

        }
        return true;
    }

    static void bombAttack(Node attacker, Node enemy) {
        int power = graph[attacker.x][attacker.y];
        graph[enemy.x][enemy.y] -= power;
        effect[enemy.x][enemy.y] = true;
        power /= 2;

        for (int i = 0; i < 8; i++) {
            int nx = (n + enemy.x + bdx[i]) % n;
            int ny = (m + enemy.y + bdy[i]) % m;

            // 공격자의 위치가 아닌 경우 (공격자는 포탄 영향 X)
            if (nx != attacker.x || ny != attacker.y) {
                graph[nx][ny] -= power;
                effect[nx][ny] = true; //영향 받은 친구 표시
            }
        }
    }

    static boolean turretCnt() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
               if (graph[i][j] != 0) {
                   cnt++;
               }
            }
        }
        return cnt == 1;
    }


//    // 공격자 선택
//    static void attackerSelection() { //1. 가장 약한 포탑 공격자로 선정
//        ArrayList<Node> attackerList = new ArrayList<>();
//        ArrayList<Node> nmList = new ArrayList<>();
//
//        int maxNM = Integer.MIN_VALUE;
//        int maxM = Integer.MIN_VALUE;
//
//        for (int i = 1; i <= n; i++) { //그래프 초기화
//            for (int j = 1; j <= m; j++) {
//                if (graph[i][j] == min) {
//                    attackerList.add(new Node(i,j));
//                    attackerX = i;
//                    attackerY = j;
//
//                }
//            }
//        }
//
//        //위에서 2개 이상이라면
//        if (attackerList.size() >= 2) { //행과 열의 합이 가장 큰 포탑
//            for (int i = 0; i < attackerList.size(); i++) {
//                int nmX = attackerList.get(i).x;
//                int nmY = attackerList.get(i).y;
//
//                if (maxNM < (nmX + nmY)) {
//                    maxNM = (nmX + nmY);
//                    nmList.add(new Node(nmX, nmY));
//
//                    attackerX = nmX;
//                    attackerY = nmY;
//
//                }
//            }
//        }
//
//        //위에서 2개 이상이라면
//        if (nmList.size() >= 2) { //열 값이 가장 큰 포탑
//            for (int i = 0; i < nmList.size(); i++) {
//                int mX = nmList.get(i).x;
//                int mY = nmList.get(i).y;
//
//                if (maxM < mY) {
//                    maxM = mY;
//
//                    attackerX = mX;
//                    attackerY = mY;
//
//                }
//            }
//        }
//    }
//
//
//    static void enemySelection() { // 적군 선택
//        ArrayList<Node> enemyList = new ArrayList<>();
//        ArrayList<Node> nmList = new ArrayList<>();
//
//        int minNM = Integer.MAX_VALUE;
//        int minM = Integer.MAX_VALUE;
//
//        for (int i = 1; i <= n; i++) { //그래프 초기화
//            for (int j = 1; j <= m; j++) {
//                if (graph[i][j] == max) {
//                    enemyList.add(new Node(i,j));
//                    enemyX = i;
//                    enemyY = j;
//                }
//            }
//        }
//
//        //위에서 2개 이상이라면
//        if (enemyList.size() >= 2) { //행과 열의 합이 가장 작은 포탑
//            for (int i = 0; i < enemyList.size(); i++) {
//                int nmX = enemyList.get(i).x;
//                int nmY = enemyList.get(i).y;
//
//                if (minNM > (nmX + nmY)) {
//                    minNM = (nmX + nmY);
//                    nmList.add(new Node(nmX, nmY));
//
//                    enemyX = nmX;
//                    enemyY = nmY;
//                }
//            }
//        }
//
//        //위에서 2개 이상이라면
//        if (nmList.size() >= 2) { //열 값이 가장 작은 포탑
//            for (int i = 0; i < nmList.size(); i++) {
//                int mX = nmList.get(i).x;
//                int mY = nmList.get(i).y;
//
//
//                if (minM > mY) {
//                    minM = mY;
//
//                    enemyX = mX;
//                    enemyY = mY;
//
//                }
//            }
//        }
//    }


}
