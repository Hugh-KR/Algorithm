package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724_230413 {
    static int N,M;
    static int[][] graph = new int[1001][1001];
    static boolean[] visited = new boolean[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 간선 연결
            graph[a][b] = graph[b][a] = 1;
        }

        for (int i = 0; i <= N*2; i++) {
            for (int j = 0; j <= M*2; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);


    }

    static void dfs(int idx) {
        if (!visited[idx]) {
            visited[idx] = true;
            for (int i = 1; i <= N; i++) {

                if (graph[idx][i] == 1) {
                    dfs(i);
                }

            }
        }
    }
}
