package BOJ.BackTracking;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    22:59~23:12 (13분)

    *백트래킹*

    - N개의 자연수 중에서 M개를 고른 수열
    - 고른 수열은 오름차순이어야 한다.
    - 수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class BOJ_15655_230818 {
    static int n,m;
    static int[] arr;
    static int[] val;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n]; // 입력 정수값
        val = new int[m]; // 출력 정수값
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == m) {
            for (int v : val) {
                sb.append(v + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (depth > 0 && val[depth-1] > arr[i]) continue;
            val[depth] = arr[i];

            visited[i] = true;
            dfs(depth+1);
            visited[i] = false;
        }
    }
}
