package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649_230330 {
    static boolean[] visit;
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new boolean[N];
        arr = new int[M];

        dfs(N,M,0);

    }

    static void dfs(int N, int M, int depth) {

        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i] == false) {

                visit[i] = true;
                arr[depth] = i + 1;
                dfs(N, M, depth + 1);

                visit[i] = false;
            }
        }
        return;
    }
}
