package BOJ.Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
public class BOJ_1916_230712 {
    static int N, M;
    static ArrayList<ArrayList<Node>> a; // 인접리스트.
    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리.
    static boolean[] check; // 방문 확인.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            a = new ArrayList<>();
            dist = new int[N + 1];
            check = new boolean[N + 1];

            Arrays.fill(dist, Integer.MAX_VALUE);

            for (int i = 0; i <= N; i++) {
                a.add(new ArrayList<>());
            }

            // 단방향 인접 리스트 구현.
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                // start에서 end로 가는 weight (가중치)
                a.get(start).add(new Node(end, weight));
            }

            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                min = Math.min(min, dijkstra(i));
            }
            sb.append(min).append("\n");

        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    public static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[start];
    }
}
