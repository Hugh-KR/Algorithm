package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    23:17~23:25 (8분)

    *백트래킹*

    - N개의 자연수 중에서 M개를 고른 수열
    - 같은 수를 여러 번 골라도 된다.
    - 사전 순으로 증가하는 순서로 출력해야 한다.
 */
public class BOJ_15656_230818 {
    static int n,m;
    static int[] arr;
    static int[] val;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n]; // 입력 배열
        val = new int[m]; // 출력 배열

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
            val[depth] = arr[i];
            dfs(depth+1);
        }
    }
}
