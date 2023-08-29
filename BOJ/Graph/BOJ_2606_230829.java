package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    *BFS,DFS*

    - BFS,DFS 둘다 풀어보기
    - 양방향 인접리스트 -> map의 모든곳을 채워야 모든곳을 탐색할 수 있다?
    - 방문하고 끝내야하는 경우와 재방문 할 수 있는 경우

 */
public class BOJ_2606_230829 {
    static int n,k;
    static int cnt = 0;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        k = Integer.parseInt(br.readLine()); // 쌍의 수

        map = new ArrayList[n+1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

//        bfs(1);
        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int start) {

        visited[start] = true;
        for (int i = 0; i < map[start].size(); i++) {
            if (!visited[map[start].get(i)]) {
                dfs(map[start].get(i));
                cnt++;
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();


        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < map[now].size(); i++) {
                if (!visited[map[now].get(i)]) {
                    cnt++;
                    visited[map[now].get(i)] = true;
                    q.offer(map[now].get(i));
                }
            }
        }
    }

}
