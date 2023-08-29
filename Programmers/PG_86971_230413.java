package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class PG_86971_230413 {
    static int[][] graph;

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        System.out.println(solution(n, wires));
    }

    static int solution(int n, int[][] wires) {
        int answer = n;
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        for (int i = 0; i < wires.length; i++) {

            int from = wires[i][0], to = wires[i][1];
            graph[from][to] = 0;
            graph[to][from] = 0;

            answer = Math.min(answer, bfs(n, from));
            graph[from][to] = 1;
            graph[to][from] = 1;

        }

        return answer;
    }

    static int bfs(int n, int x) {
        boolean[] visited = new boolean[n + 1];
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();
        visited[x] = true;
        q.offer(x);

        while (!q.isEmpty()) {
            int tmp = q.poll();

            for (int i = 1; i <= n; i++) {
                if (graph[tmp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    cnt++;
                }
            }
        }

        return Math.abs(cnt - (n - cnt));
    }
}
