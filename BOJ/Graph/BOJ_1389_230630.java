package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1389_230630 {
    /**
     * 최단거리 = BFS?
     *
     */
    static int n,m;
    static int result;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] graph;

    static class KB {
        int friend;
        int val;

        public KB(int friend, int val) {
            this.friend = friend;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        // 모든 친구 순회
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];
            bfs(i);
        }

        System.out.println(result);
    }


    static void bfs(int start) {
        Queue<KB> q = new LinkedList<>();
        int cnt = 0;

        // 자기자신 true 처리
        visited[start] = true;
        q.offer(new KB(start, 0));

        while (!q.isEmpty()) {
            KB kb = q.poll();
            cnt += kb.val;

            for (int i = 1; i <= n; i++) {
                int num = graph[kb.friend][i];

                if (num == 1 && visited[i] == false) {
                    visited[i] = true;
                    q.offer(new KB(i, kb.val + 1));
                }
            }
        }

        // 최솟값 갱신하며 누가 가장 작은지 갱신
        if (min > cnt) {
            min = cnt;
            result = start;
        }
    }

}
