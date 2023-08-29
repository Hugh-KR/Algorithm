package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    14:56~

    *백트래킹*

    - 차있는 경우와 차있지 않은 경우
 */
public class BOJ_14712_230823 {
    static int n,m;
    static int result = 0;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        recur(0,0);
        System.out.println(result);
    }

    // 일단 모든 경우를 다 구해보자
    static void recur(int idx, int num) {
        if (idx == n*m) {
            result += num;
            return;
        }
        int x = idx/m;
        int y = idx%m;


        if (!visited[x][y]) {
            visited[x][y] = true;
            recur(idx+1, num+1);
            visited[x][y] = false;
        }
    }
}
