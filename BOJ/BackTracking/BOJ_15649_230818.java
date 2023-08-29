package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    19:45~21:58
    (꾸물꾸물 여유롭게 품. 집중해서 빠짝하자)

    *백트래킹*

    - 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

 */
public class BOJ_15649_230818 {
    static int n,m;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        arr = new int[m];

        recursion(0);
        System.out.println(sb);

    }

    static void recursion(int nCnt) {
        if (nCnt == m) {

            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                arr[nCnt] = i+1;
                visited[i] = true;
                recursion(nCnt+1);
                visited[i] = false;
            }

        }
    }

}
