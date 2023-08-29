package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    09:12~11:30

    *BFS*
    (경로 찾기)

    - 두 도시 사이의 길이 있을 수도, 없을 수도 있다. (일단 연결 되었으면 양쪽다 연결돼있음)
    - A B가 연결되어 있다면 B A도 연결되어 있다.
    - 중간에 다른 도시를 경유해서 여행 할 수도 있다.
    - 여행 일정이 주어졌을 때, 여행경로가 가능한 것인지 알아보기

    주어진 시작 지점으로 부터의 모든 경로 구하기? X

    칸칸이 경로 구해주기
    BFS로 부터 boolean 반환
 */
public class BOJ_1976_230816 {
    static int n,m;
    static int[][] map;
    static boolean[] visited; // 여행지 방문처리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        map = new int[n+1][n+1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) { // 배열 입력값 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == j) map[i][j] = 1;
            }
        }

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> houseNum = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            houseNum.add(Integer.parseInt(st.nextToken()));
        }


        for (int i = 0; i < m-1; i++) {

            if (!bfs(houseNum.get(i), houseNum.get(i+1))) { // target 값 못 찾으면 NO 반환
                sb.append("NO");
                break;
            }

            // target 값 찾았고, 모든 위치 탐색 했다면
            if (i == (m-2)) sb.append("YES");
        }

        System.out.println(sb);
    }

    static boolean bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[n+1]; // 같은 도시 여러번 방문 가능

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int house = q.poll();

            for (int i = 1; i <= n; i++) {
                if (map[house][i] == 1 && i == target) return true; // 목적지 찾음
                if (map[house][i] == 1 && !visited[i]) { // 그게 아니라면 새로운 루트 탐색
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
        return false; // 큐를 모두 탐색했음에도 목적지 못 찾음
    }
}
