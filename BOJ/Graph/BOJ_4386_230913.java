package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    14:24~15:03 (39분)

    *MST*

    * 별자리의 조건

    - 별자리를 이루는 선은 서로 다른 두 별을 일직선으로 이은 형태이다
    - 모든 별들은 별자리 위의 선을 통해 직/간접적으로 이어져 있어야 한다.

    선을 하나 이을 때마다 두 별 사이의 거리만큼의 비용이 든다.
    별자리 만드는 최소 비용 구하기
 */

public class BOJ_4386_230913 {
    static int n;
    static double[][] arr;
    static ArrayList<Graph>[] graph;

    static class Graph implements Comparable<Graph>{
        int v;
        double cost;

        public Graph(int v, double cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Graph o) {
            return (int) (this.cost - o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        arr = new double[n+1][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;

            graph[i] = new ArrayList<>(); // 그래프 초기화
        }

        makeGraph(); // 모든 별들 이어줘야 함(가중치 포함)
        System.out.printf("%.2f",prim());

    }


    static double prim() { // 모두 이어져 있다가 가정
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        boolean[] vosited = new boolean[n+1];
        pq.offer(new Graph(1,0.0));

        double sum = 0;
        while (!pq.isEmpty()) {
            Graph now = pq.poll();
            int v = now.v;
            double cost = now.cost;

            if (vosited[v]) continue; // 이미 방문했으면 넘어가기
            vosited[v] = true;
            sum += cost;

            for (Graph next : graph[v]) {
                pq.offer(next);
            }

        }

        return sum;
    }

    static void makeGraph() { // 모든 별들 이어줘야 함(가중치 포함)
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                double xCost = Math.pow(arr[i][0] - arr[j][0], 2);
                double yCost = Math.pow(arr[i][1] - arr[j][1], 2);

                graph[i].add(new Graph(j,Math.sqrt(xCost+yCost)));
                graph[j].add(new Graph(i,Math.sqrt(xCost+yCost)));
            }
        }
    }


}
