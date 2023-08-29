package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    13:40~16:23

    *부루트포스, DFS*
    (외판원 순회: Traveling Salesman problem(TSP))

    - 각 행렬의 성분 100만 이하 양의 정수
    - 한 외판원이 어느 한 도시에서 출발해 N개의 도시 모두 거쳐 다시 원래의 도시로 돌아오는 순회
    - 한번 갔던 도시 다시 방문 못함 (출발 도시 제외)
    - 가장 적은 비용을 들이는 여행
    - i -> j 여행 경비, 비용은 대칭적이지 않음 i -> i 는 무조건 0
    - i에서 j로 갈 수 없는 경우 [i][j] = 0

    - 항상 순회할 수 있는 경우만 입력으로 주어짐
 */
public class BOJ_10971_230828 {
    static int n;
    static int[][] map;
    static boolean[] visited;
    static long result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];


        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            dfs(i,i,0);
        }



        System.out.println(result);
//        System.out.println(findRoute());
    }

    static void dfs(int start, int now, long cost) {
        if (allVisited()) { // 종료 조건
            if (map[now][start] != 0) { // 모두 방문했고, 마지막 도시에서 처음으로 가는 루트가 있는 경우
                result = Math.min(result, cost + map[now][start]);
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && map[now][i] != 0) {

                // 백트래킹
                visited[i] = true;
                dfs(start, i,cost + map[now][i]);
                visited[i] = false;
            }
        }



    }

    static boolean allVisited() {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }


//    static class Node {
//        int i, j;
//
//        public Node(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//    }
}
