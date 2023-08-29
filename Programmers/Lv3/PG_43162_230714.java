package Programmers.Lv3;

import java.util.*;

public class PG_43162_230714 {
    static int sumCount = 0;
    static boolean[][] visited;

    /**
     * x, y 좌표를 위한 노드
     */
    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }

    public static void main(String[] args) {
        // write your code here

        int[][] a = new int[][] { {1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(solution(3, a));
    }

    static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) { // 방문하지 않았을때
                    if (computers[i][j] == 1) { // 1일때
                        bfs(i, j, n, computers);
                        sumCount++;
                    }
                }
            }
        }

        answer = sumCount;
        return answer;
    }

    static void bfs(int x, int y, int n, int[][] graph) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            /* 탐색 대상 : node */
            Node node = q.poll();

            int start = node.getY();
            for (int end = 0; end < n; end++) {
                /* 방문 가능 조건 */
                /* 방문하지 않았고, 숫자가 같을 경우  */
                if (!visited[start][end] && graph[start][end] == graph[x][y]) {
                    visited[start][end] = true;

                    /* queue push */
                    q.offer(new Node(start, end));
                }
            }
        }
    }
}
