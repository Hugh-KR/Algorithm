package BOJ.Graph;

import java.io.*;
import java.util.*;

/*
    09:10~17:07 (7시간 57분)

    *bfs*

    - 항상 최단 경로만 이동
    - 상하좌우 인접한 빈칸 이동가능
    - 손님 데려다줄 때마다 연료 충전, 연료 바닥나면 업무 마감
    - 여러 승객이 같이 탑승하는 경우는 없고, 각 승객은 출발지에서만 타고 목적지에서만 내린다
    - 택시의 현재 위치에서 최단거리가 가장 짧은 승객을 고름
        * 우선순위 -> 그런 승객 여러 명이면 그중 행번호가 가장 작은 승객, 열 번호 작은 승객 (우선순위 큐?)

    - 택시와 승객 같은 위치에 서 있으면 그 승객까지 최단거리 0, 연료 한칸당 1씩 소모
    - 한 승객을 목적지로 성공적으로 이동시키면, 그 승객을 태워 이동하면서 소모한 연료 양의 두 배가 충전된다
    - 이동도중 연료 바닥나면 이동 실패
    - 승객을 목적지로 이동시킨 동시에 연료 바닥나는 경우는 실패로 간주하지 않음

    - 연료는 무한히 많이 담을 수 있음
 */
public class BOJ_19238_230903 {
    static int N, M, fuel;
    static int count = 0;

    static int[][] map;
    static boolean[][] visited;
    static Position taxi;
    static Position[] destination;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
//    static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    static StringTokenizer st;

    static class Position implements Comparable<Position> {
        int r, c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Position o) {
            if (this.r != o.r) return this.r - o.r;
            return this.c - o.c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());


        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        destination = new Position[M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) map[i][j] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        taxi = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = i;
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            destination[i] = new Position(r, c);
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < M; i++) {
            int passenger = findPassenger(taxi);
            fuel -= count;
            if (passenger == -1 || fuel <= 0) {
                System.out.println(-1);
                return;
            }
//            System.out.println(passenger);
            int use = goDest(taxi, passenger); // passenger = 어디로 가야하는지 알려주는 값

            if (fuel < use || use == -1) {
                System.out.println(-1);
                return;
            }

            fuel += use; // use = 카운트 값

            map[taxi.r][taxi.c] = 0;
            taxi = destination[passenger]; // 택시 위치를 도착지로 변경
        }

        System.out.println(fuel);

    }

    static int findPassenger(Position pos) {
        Queue<Position> queue = new LinkedList<>();
        PriorityQueue<Position> pq = new PriorityQueue<>();    // 손님을 담을 PQ
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited[i], false);
        }



        count = 0;            // BFS에서 탐색중인 depth를 나타냄 (= 거리)

        queue.offer(pos);
        if (map[pos.r][pos.c] > 0) {        // 현재 택시의 위치가 승객이 있는 자리
            return map[pos.r][pos.c];
        }

        int size = 0;
        while (!queue.isEmpty()) {
            count++;
            size = queue.size();
            for (int step = 0; step < size; step++) {
                Position temp = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = temp.r + dx[i];
                    int nc = temp.c + dy[i];


                    if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] >= 0) {
                        if (map[nr][nc] > 0) {        // 손님이면 pq에도 넣어준다.
                            pq.offer(new Position(nr, nc));
                        }
                        queue.offer(new Position(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }

            if (!pq.isEmpty()) {        // 같은 거리의 탐색이 끝났다면 손님이 있었는지 확인한다.
                taxi = pq.poll();    // 택시의 위치를 손님의 위치로 바꿔준다.

//                for (int i = 1; i <= N; i++) {
//                    for (int j = 1; j <= N; j++) {
//                        System.out.print(map[i][j] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();

                return map[taxi.r][taxi.c];    // 거리를 리턴한다.
            }
        }
        return -1;        // 손님을 찾을 수 없다면 -1을 리턴한다.
    }

    static int goDest(Position taxi, int passNo) {
        Queue<Position> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited[i], false);
        }

        queue.offer(taxi);
        visited[taxi.r][taxi.c] = true;

        count = 0;

        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int step = 0; step < size; step++) {
                Position temp = queue.poll();

                if (temp.r == destination[passNo].r && temp.c == destination[passNo].c) {

//                for (int i = 1; i <= N; i++) {
//                    for (int j = 1; j <= N; j++) {
//                        System.out.print(copyMap[i][j] + " ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
                    return count;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = temp.r + dx[i];
                    int nc = temp.c + dy[i];

                    if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] >= 0) {
                        queue.offer(new Position(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    static boolean isIn(int r, int c) {
        return r >= 1 && c >= 1 && r <= N && c <= N;
    }

}
