package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    14:18~15:30

    * BFS *
    (퍼져 나가는 문제)

    보물은 서로 간에 최단 거리로 이동하는데 있어
    가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다.

    둘 사이에 최단 거리로 이동하는 시간 구하기.

    매번 방문처리 갱신해줘야함.
    (첫번째 계산 값이 최적값이라고 확신할 수 없기 때문.)
 */

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ_2589_230803 {
    static int x, y;
    static int max = Integer.MIN_VALUE; //모든 경우의 수 에 대한 max 값 갱신
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] dist;
    static char[][] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        graph = new char[x][y];
        for (int i = 0; i < x; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (graph[i][j] == 'L') {
                    visited = new boolean[x][y];
                    dist = new int[x][y];
                    bfs(i, j);
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (isRange(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    dist[nx][ny] = (dist[node.x][node.y] + 1);
                    max = Math.max(max, dist[nx][ny]);
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    static boolean isRange(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < x && ny < y);
    }
}
