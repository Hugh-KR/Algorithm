package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11724_230518 {
    static int N, M;
    static int result = 0;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        pre();
        System.out.println(result);
    }

    static void pre() {
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }
    }

    static void dfs(int val) {
        if (visited[val]) {
            return;
        }

        visited[val] = true;
        for (int i = 0; i < N; i++) {
            if (arr[val][i] == 1) {
                dfs(i);
            }
        }
    }
}
