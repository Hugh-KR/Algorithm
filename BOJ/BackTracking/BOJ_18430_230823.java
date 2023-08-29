package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    13:36~14:48

    *백트래킹*

    - 중심이 되는 칸은 강도의 영향 2배
    - 부매랑 강도의 최댓값
    - 각 칸은 중심칸이 될 수 있다.
 */
public class BOJ_18430_230823 {
    static int n,m;
    static int[][] arr;
    static ArrayList<Boome>[] boome = new ArrayList[4];
    static int maxResult = Integer.MIN_VALUE;
    static boolean[][] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < 4; i++) {
            boome[i] = new ArrayList<>();
        }

        // 부매랑 각도 넣어주기
        boome[0].add(new Boome(0,-1));
        boome[0].add(new Boome(1,0));

        boome[1].add(new Boome(0,-1));
        boome[1].add(new Boome(-1,0));

        boome[2].add(new Boome(-1,0));
        boome[2].add(new Boome(0,1));

        boome[3].add(new Boome(0,1));
        boome[3].add(new Boome(1,0));


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[n][m];

        recur(0,0);

        System.out.println(maxResult);

    }

    // 방문 하는 경우와 방문하지 않는 경우
    static void recur(int idx, int num) {

        if (idx == n*m) {
            maxResult = Math.max(maxResult, num);
            return;
        }

        int x = (idx / m);
        int y = (idx % m);

        if (!visited[x][y]) {
            for (int i = 0; i < 4; i++) {
                int nx1 = x + boome[i].get(0).x;
                int ny1 = y + boome[i].get(0).y;
                int nx2 = x + boome[i].get(1).x;
                int ny2 = y + boome[i].get(1).y;

                if (isRange(nx1, ny1) && isRange(nx2, ny2) && !visited[nx1][ny1] && !visited[nx2][ny2]) {
                    int sum = ((arr[x][y] * 2) + arr[nx1][ny1] + arr[nx2][ny2]);
                    visited[x][y] = true;
                    visited[nx1][ny1] = true;
                    visited[nx2][ny2] = true;
                    recur(idx + 1, num+sum);
                    visited[x][y] = false;
                    visited[nx1][ny1] = false;
                    visited[nx2][ny2] = false;
                }
            }
        }

        recur(idx+1, num); // 만족하는 값 없을경우
    }

    static boolean isRange(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < n && ny < m);
    }

    static class Boome {
        int x,y;

        public Boome(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
