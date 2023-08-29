package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    22:34~22:42 (8분)

    *백트래킹*

    - 1부터 N까지 자연수 중에서 M개를 고른 수열
    - 같은 수를 여러 번 골라도 된다.
    - 고른 수열은 비내림차순이어야 한다.
 */
public class BOJ_15652_230818 {
    static int n,m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
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
            if(depth > 0 && arr[depth-1] > i+1) continue;
            arr[depth] = i+1;
            dfs(depth+1);
        }
    }
}
