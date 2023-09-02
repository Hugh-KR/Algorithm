package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    16:32~
    23.09.02 15:04

    *DP(탑다운)*

    - 2차원 DP
 */
public class BOJ_1937_230901 {
    static int n;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result = Math.max(result, pro(i,j));
            }
        }


        System.out.println(result+1);

    }

    static int pro(int x, int y) {

        if (dp[x][y] != 0) return dp[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isRange(nx,ny) && map[nx][ny] > map[x][y]) {
                dp[x][y] = Math.max(dp[x][y], pro(nx,ny) + 1);
            }
        }

        return dp[x][y];
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean isRange(int nx, int ny) {
        return (nx >= 1 && ny >= 1 && nx <= n && ny <= n);
    }
}
