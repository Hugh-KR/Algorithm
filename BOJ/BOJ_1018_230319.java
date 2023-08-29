package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_230319 {
    static boolean[][] arr;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String check = br.readLine();
            for (int j = 0; j < m; j++) {
                if (check.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        int N_row = n - 7;
        int M_col = m - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i,j);
            }
        }

        System.out.println(min);
    }

    static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int cnt = 0;

        boolean TF = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {

                if (arr[i][j] != TF) {
                    cnt += 1;
                }
                TF = !TF;
            }
            TF = !TF;
        }

        cnt = Math.min(cnt, 64 - cnt);

        min = Math.min(min, cnt);
    }
}
