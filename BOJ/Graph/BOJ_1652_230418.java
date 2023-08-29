package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1652_230418 {
    static int N;
    static int[][] graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == '.') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = 1;
                }
            }
        }

        int rCnt = 0, cCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i + 1 < N) {
                    if (graph[i][j] == 0 && graph[i + 1][j] == 0 && (i + 2 >= N || graph[i + 2][j] == 1)) {
                        cCnt++;
                    }
                }
                if (j + 1 < N) {
                    if (graph[i][j] == 0 && graph[i][j + 1] == 0 && (j + 2 >= N || graph[i][j + 2] == 1)) {
                        rCnt++;
                    }
                }
            }
        }

        System.out.print(rCnt + " " + cCnt);
    }
}
