package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667_230517 {
    static int[][] idx = new int[][]{{-1, 0},{0, 1},{1, 0},{0, -1}};
    static String[] arr;
    static boolean[][] visited;
    static int group_cnt;
    static ArrayList<Integer> group;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        arr = new String[N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        pre();
        sb.append(group.size()).append("\n");
        for (int val : group) {
            sb.append(val).append("\n");
        }

        System.out.println(sb);
    }

    static void pre() {
        group = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if (!visited[i][j] && arr[i].charAt(j) == '1') {
                    group_cnt = 0;
                    dfs(i, j);
                    group.add(group_cnt);
                }
            }
        }
        // 찾은 단지 정보 오름차순 정렬
        Collections.sort(group);
    }

    static void dfs(int x, int y) {
        // 단지에 속한 집의 개수 증가, visited 체크 하기
        group_cnt++;
        visited[x][y] = true;

        // 인접한 집으로 새로운 방문하기
        for (int i = 0; i < 4; i++) {
            int nx = x + idx[i][0];
            int ny = y + idx[i][1];

            if (isRange(nx, ny) && arr[nx].charAt(ny) == '1' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

    // 범위 초가 확인
    static boolean isRange(int nx, int ny) {
        if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length) {
            return true;
        }
        return false;
    }
}
