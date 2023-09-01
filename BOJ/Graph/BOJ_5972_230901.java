package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 13:04~13:37
 * (result 에 w 넣어서 오래걸림)
 *
 * *다익스트라*
 *
 * - 1에서 N 까지 최소 비용 구하기
 * - IFN = 50000000, 5천만
 */
public class BOJ_5972_230901 {
    static int n,m;
    static ArrayList<Node>[] list;
    static int IFN = 50000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) { // 이진 리스트 초기화
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 양방향 인접 리스트
            list[v].add(new Node(e,w));
            list[e].add(new Node(v,w));
        }

        System.out.println(dijkstra(1,n));
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] result = new int[n+1]; // 가중치 담을 배열
        boolean[] visited = new boolean[n+1];

        Arrays.fill(result, IFN); // 최솟값 구하기 위해 채우기

        pq.offer(new Node(start, 0));
        result[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.e]) continue;
            visited[now.e] = true;

            for (Node next : list[now.e]) {
                // 아직 엔드 포인트 방문하지 않았어야함
                if (!visited[end] && result[next.e] > result[now.e] + next.w) {
//                    System.out.println(next.e + " " + next.w);
                    result[next.e] = result[now.e] + next.w; // 최솟값으로 갱신 시킴
                    pq.offer(new Node(next.e, result[next.e]));
                }
            }
        }

        return result[end];
    }

    static class Node implements Comparable<Node>{
        int e,w;

        public Node (int e, int w){
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) { // 정렬의 명시
            return this.w - o.w;
        }
    }
}
