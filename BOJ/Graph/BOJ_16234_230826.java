package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    09:10~10:06

    *그래프*

    1 <= N <= 50
    1 <= L,R <= 100

    - 국경선을 공유하는 두 나라의 인구차가 L명 이상 R명 이하라면, 두 나라가 공유하는 국경선 연다
    - 국경선 열려있어 인접칸만을 이용해 이동할 수 있으면, 그 나라는 하루동안 연합
    - 열려야 하는 국경선 모두 열고 인구 인동 시작
    - 인구 이동이 발생하는 일수가 2000번 보다 작거나 같은 입력만 주어짐

 */
public class BOJ_16234_230826 {
    static int n,L,R;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Country> moveList;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) { // 배열 초기값 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0,0);

//        int sum = 0;
//        int cnt = 0;
//        for (int i = 0; i < n; i++) { // 배열 초기값 입력
//            for (int j = 0; j < n; j++) {
////                System.out.print(visited[i][j] + " ");
//                if (visited[i][j]) {
//                    sum += map[i][j];
//                    cnt++;
//                }
//            }
////            System.out.println();
//        }

        System.out.println(moveCountry());
    }

    static int moveCountry () {
        int resultCnt = 0;

        while (true) {
            boolean moveFlag = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i,j);
                        if (moveList.size() > 1) {
                            changeMovePeople(sum);
                            moveFlag = true;
                        }
                    }
                }
            }
            if (!moveFlag) return resultCnt;
            resultCnt++;
        }
    }

    static void changeMovePeople(int sum) {
        int peoepleAvg = (sum / moveList.size());

        for (int i = 0; i < moveList.size(); i++) {
            Country country = moveList.get(i);
            map[country.r][country.c] = peoepleAvg;
        }
    }

    static int bfs(int x, int y) {
        Queue<Country> q = new LinkedList<>();
        moveList = new ArrayList<>();

        q.offer(new Country(x,y));
        moveList.add(new Country(x,y));
        visited[x][y] = true;

        int resultSum = map[x][y]; // 인구 합
        while(!q.isEmpty()) {
            Country country = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = country.r + dx[i];
                int ny = country.c + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny]) {
                    if (L <= Math.abs(map[country.r][country.c]-map[nx][ny]) && Math.abs(map[country.r][country.c]-map[nx][ny]) <= R){

                        visited[nx][ny] = true;
                        q.offer(new Country(nx, ny));
                        moveList.add(new Country(nx,ny));
                        resultSum += map[nx][ny];

                    }
                }
            }
        }
        return resultSum;
    }

    static boolean isRange(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < n && ny < n);
    }

    static class Country {
        int r,c;

        public Country(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
