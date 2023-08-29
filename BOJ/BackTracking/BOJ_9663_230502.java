package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_230502 {
    static int N;
    static int[] arr;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        dfs(0);
        System.out.println(cnt);
    }

    static void dfs(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if (Possibility(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean Possibility(int depth) {
        for (int i = 0; i < depth; i++) {

            // 같은 행에 있을때
            if (arr[depth] == arr[i]) {
                return false;
            }
            // 대각선인 경우
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
