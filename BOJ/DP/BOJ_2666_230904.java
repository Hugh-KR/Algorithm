package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    14:25~17:31 (3시간 6분)

    *DFS*

    3 < 벽장의 개수 <= 20

    - 모든 벽장의 이동횟수를 구해볼까?
 */
public class BOJ_2666_230904 {
    static int n;
    static int openDoor_1, openDoor_2;
    static int m; // 사용할 벽장 순서의 길이 (최대 20)
    static int[] door;
    static int minResult = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        door = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        openDoor_1 = Integer.parseInt(st.nextToken());
        openDoor_2 = Integer.parseInt(st.nextToken());


        m = Integer.parseInt(br.readLine());
        door = new int[m+1];
        for(int i = 1; i <= m; i++) {
            door[i] = Integer.parseInt(br.readLine());
        }

        dfs(openDoor_1,openDoor_2,1,0);
        System.out.println(minResult);
    }

    // dfs를 사용해서 왼쪽으로 이동시키는 경우와 오른쪽으로 이동시키는 경우 모두 고려
    static void dfs(int openDoor_1, int openDoor_2, int depth, int cnt) {
        if (depth == m+1) {
            minResult = Math.min(minResult, cnt);
            return;
        }

        int a = Math.abs(door[depth] - openDoor_1);
        int b = Math.abs(door[depth] - openDoor_2);

        dfs(door[depth], openDoor_2, depth+1, cnt + a); // openDoor_1 으로 옮김
        dfs(openDoor_1, door[depth], depth+1, cnt + b); // openDoor_2 으로 옮김

    }
}
