package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    14:00~

    *다익스트라*

    - 지름길의 개수 N과 고속도로의 길이 D가 주어짐

    N <= 12
    D <= 10000

    - N개의 줄에 지름길 시작 위치, 도착 위치, 지름길의 길이 주어짐
    - 모든 위치와 길이는 10000보다 작거나 같은 음이 아닌 정수

    - 세준이가 운전해야하는 거리의 최솟값 출력하기
    - 모든 위치와 길이는 10000보다 작거나 같은 음이 아닌 정수 -> 다익스트라

 */
public class BOJ_1446_230906 {
    static ArrayList<Node>[] map;
    static int result = 0;
    static int n,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 이중연결 리스트
            map[i].add(new Node(v,e,w));

        }
    }

    static void dijkstra(int v, int e, int w) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[d+1];

        pq.offer(new Node(v, e, w));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (int i = now.v; i <= now.e; i++) {
                if (!visited[i]) break;
                visited[i] = true;
            }
        }


    }

    static class Node implements Comparable<Node> {

        int v,e,w;

        public Node (int v, int e, int w) {
            this.v = v;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo (Node o){
            return this.w - o.w;
        }
    }
}


