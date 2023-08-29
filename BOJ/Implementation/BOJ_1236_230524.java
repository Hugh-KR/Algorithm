package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1236_230524 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];

        // 성 초기화
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int row = 0; // 행
        int col = 0; // 열
        for (int i = 0; i < N; i++) {
            boolean flag = false;
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'X') flag = true;
            }
            if (!flag) row++;
        }

        for (int i = 0; i < M; i++) {
            boolean flag = false;
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == 'X') flag = true;
            }
            if (!flag) col++;
        }

        sb.append(Math.max(row, col));
        System.out.println(sb);
    }
}
