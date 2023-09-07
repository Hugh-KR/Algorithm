package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/*
    13:15~13:58

    *MST*
    프림 = 다익스트라
    크루스칼 = 유니온 파인드

    - n개의 행성간 플로우 설치
    - 두 행성 간 플로우 연결하면 다른 행성으로 무시할 수 있을만큼 짧은 시간 이동가능
    - 치안 유지위한 제국군 주둔
    - 제국군의 모든 행성 연결하면서 플로우 관리 비용 최소한으로 줄임
    - 플로우 관리 비용은 Cij -> i = j 인 경우 항상 0

    - 행성간 모든 간선 주어짐, N*N 배열 형태로 들어옴 -> 프림 알고리즘
    - 최대 비용 1억까지 주어짐

    모든 행성을 연결했을 때, 최소 플로우의 관리 비용 출력

 */
public class BOJ_16398_230906 {
    static int n;
    static ArrayList<Edge>[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n+1];

        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int w = Integer.parseInt(st.nextToken());
                map[i].add(new Edge(j, w));
            }
        }


        System.out.println(dijkstra());
    }

    static long dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        pq.offer(new Edge(1,0));

        int cnt = 0;
        long sum = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.e]) continue; // 방문한 노드면 패스
            visited[now.e] = true;

            sum += now.w;
            for (Edge next : map[now.e]) {
                pq.offer(next);
            }

            cnt++;
            if (cnt == n) break;
        }

        return sum;
    }

    static class Edge implements Comparable<Edge>{
        int e;
        int w;

        public Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }


    }
}
