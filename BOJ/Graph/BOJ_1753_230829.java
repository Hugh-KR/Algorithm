package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    15:47~

    *다익스트라*

    - BFS와 비슷하다?
    - 가중치가 1이 아니고 음의 가중치도 아니기 때문에 다익스트라를 이용하여 풀이할 수 있다.
    - 다익스트라는 한 노드에서 모든 노드로 가는 최단 거리를 구할 수 있다.
    - 다익스트라는 우선순위 큐

 */
public class BOJ_1753_230829 {
    static int ver,edg;
    static ArrayList<Graph>[] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ver = Integer.parseInt(st.nextToken());
        edg = Integer.parseInt(st.nextToken());

        map = new ArrayList[ver+1];
        for (int i = 1; i <= ver; i++) {
            map[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());

        for (int i = 1; i <= edg; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[v].add(new Graph(e,w)); // 단방향 그래프
        }


        dijkstra(start);

        System.out.println(sb);

    }

    static void dijkstra(int start) {
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[ver+1];
        int[] result = new int[ver+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        pq.offer(new Graph(start, 0));
        result[start] = 0;

        while (!pq.isEmpty()) {
            Graph nowGraph = pq.poll();
            int now = nowGraph.e;

            if (visited[now]) continue;// 방문 가능한 곳 중에서
            visited[now] = true; // 1 처리 해주면서 시작

            for (Graph graph : map[now]) {
                if (result[graph.e] > result[now] + graph.w) { // 현재 노드와 연결된 노드가 갱신이 필요하다면
                    result[graph.e] = result[now] + graph.w;
                    pq.offer(new Graph(graph.e, result[graph.e]));
                }
            }
        }


        print(visited, result);

    }

    static void print(boolean[] visited, int[] result) {
        for (int i = 1; i <= ver; i++) {
            if (visited[i]) sb.append(result[i]).append("\n");
            else sb.append("INF").append("\n");
        }
    }

    static class Graph implements Comparable<Graph>{
        int e,w;

        public Graph (int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Graph o) {
            return w - o.w;
        }
    }
}
