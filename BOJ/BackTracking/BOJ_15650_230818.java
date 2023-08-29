package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    22:00~22:24

    *백트래킹*

    - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    - 고른 수열은 오름차순이어야 한다.
 */
public class BOJ_15650_230818 {
    static int n,m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n];

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            arr[depth] = i+1;
            visited[i] = true;
            dfs(depth+1);

            for (int j = i+1; j < n; j++) {
                visited[j] = false; // 중복 없이..?
            }
        }
    }
}
