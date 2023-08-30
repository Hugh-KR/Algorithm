package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;

/*
    13:10~13:56 (46분)

    *다익스트라*

    우선순위 큐 사용

    - 두 가지 조건을 만족하는 특정한 최단 경로
    - 임의로 주어진 두정점은 반드시 통과해야 한다. *
    - 한번 이동했던 간선 다시 이동 가능
    - 반드시 최단 경로

    - 최단 경로 없을때는 -1 출력

    반드시 통과 해야하는 임의로 주어지는 정점 v1, v2
    v1 != v2
    v1 != N
    v2 != 1
    임의의 두 정점 u와 v사이에는 간선이 최대 1개 존재?
 */
public class BOJ_1504_230830 {
    static int n,e;
    static ArrayList<Map>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) { // 이진 연결리스트 초기화
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) { // 정점 간선 입력
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // 양방향 인접 리스트
            list[v].add(new Map(e,w));
            list[e].add(new Map(v,w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // v1과 v2를 지나는 모든 최소거리 구하기
        int v1Tov2 = 0;
        v1Tov2 += dijkstra(1,v1);
        v1Tov2 += dijkstra(v1,v2);
        v1Tov2 += dijkstra(v2,n);

        int v2Tov1 = 0;
        v2Tov1 += dijkstra(1,v2);
        v2Tov1 += dijkstra(v2,v1);
        v2Tov1 += dijkstra(v1,n);

        if (v1Tov2 >= 200000000 && v2Tov1 >= 200000000) sb.append(-1).append("\n");
        else sb.append(Math.min(v1Tov2, v2Tov1)).append("\n");

        System.out.println(sb);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Map> pq = new PriorityQueue<>();
        int[] result = new int[n+1]; // 거리별 가중치 넣어줄 배열
        boolean[] visited = new boolean[n+1];

        // Integer.MAX_VALUE 넣으면 오버플로우 발생
        Arrays.fill(result, 200000000); // 최단 거리 찾기위해 최댓값 정렬

        pq.offer(new Map(start, 0));
        result[start] = 0;

        while (!pq.isEmpty()) {
            Map now = pq.poll();

            if(visited[now.e]) continue;
            visited[now.e] = true; // 방문하지 않았다면 방문처리
            for (Map next : list[now.e]) {
                // 1. 현재 지점을 거쳐가는것 보다 다음 방문할 곳의 가중치가 더 크다면
                // 2. end 포인트에 방문하지 않았어야 함
                if (!visited[end] && result[next.e] > result[now.e] + next.w) {
                    result[next.e] = result[now.e] + next.w; // 거쳐가는 방법으로 업데이트
                    pq.offer(new Map(next.e, result[next.e]));
                }
            }

        }
        return result[end];
    }


    static class Map implements Comparable<Map> {
        int e,w;

        public Map(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Map o) {
            return this.w - o.w;
        }

    }
}
