package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11403_230518 {
    static int N;
    static int[][] graph;
    static int[][] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pre();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void pre() {
        for (int i = 0; i < N; i++) {
            visited = new boolean[N]; // 행(i) 마다 경로 탐색해야 하므로 방문한 곳 초기화
            for (int j = 0; j < N; j++) {
                if (!visited[j] && graph[i][j] == 1) {
                    dfs(i ,j);
                }
            }
        }
    }

    static void dfs(int x, int y) {
        visited[y] = true;
        result[x][y] = 1;

        for (int i = 0; i < N; i++) {
            if (graph[y][i] == 1 && !visited[i]) {
                dfs(x, i);
            }
        }
    }
}
