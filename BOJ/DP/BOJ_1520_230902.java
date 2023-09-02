package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520_230902 {
    static int m,n;
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m+1][n+1];
        dp = new int[m+1][n+1];
        visited = new boolean[m+1][n+1];

        for (int[] a : dp) {
            Arrays.fill(a,-1);
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pro(1,1);

        System.out.println(dp[1][1]);
//        System.out.println(pro(1,1));

//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    static int pro(int x, int y) { // 탑다운 DP (메모이제이션)

        if (x == m && y == n) {
            return 1;
        }

        if (dp[x][y] != -1) return dp[x][y];

        int route = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx,ny) && map[nx][ny] < map[x][y]) {

                route += pro(nx,ny);

            }
        }
        dp[x][y] = route;
        return dp[x][y];
    }

    static boolean isRange(int nx, int ny) {
        return (nx >= 1 && ny >= 1 && nx <= m && ny <= n);
    }
}
