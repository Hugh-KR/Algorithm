package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    14:31~15:20

    *BFS*

    - 상하좌우 이웃한 육지로만 가능
    - 보물은 가장 긴 시간이 걸리는 육지 두 곳에 나뉘에 묻혀있다.
    - 한칸이동 한시간
    - 최단거리 이동, 가장 긴 시간 걸리는 육지 두 곳에 나뉘어 묻혀있음
    - 두 곳을 최단 거리로 이동하려면 같은 곳 두 면 이상 지나기 X, 멀리 돌아가기 X

    - 보물이 묻힌 두 곳 간의 최단 거리 이동 시간 구하기

    모든 L을 탐색하며 가장 긴 시간이 걸리는 육지 파악

    탐색하는데 있어 매번 대소비교 진행 -> 개선 방향 생각해 볼 것
 */
public class BOJ_2589_230829 {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int a,b;
    static char[][] map;
    static int[][] result;

    static int resultMax = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        map = new char[a][b];
        for (int i = 0; i < a; i++) {
            map[i] = br.readLine().toCharArray(); // 0부터 들어감
        }

        // 모든 L에 대해 BFS 진행
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }

        System.out.println(resultMax);

    }

    static void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[a][b]; // 방문 처리
        result = new int[a][b]; // 거리 표현용 배열

        q.offer(new Node(i,j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if (isRange(nx,ny) && !visited[nx][ny] && map[nx][ny] == 'L') {
                    result[nx][ny] = (result[x][y] + 1); // 거리 1 추가

                    resultMax = Math.max(resultMax, result[nx][ny]); // 대소비교

                    visited[nx][ny] = true;
                    q.offer(new Node(nx,ny)); // 이동 가능한 방향 추가
                }
            }
        }
    }

    static boolean isRange(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < a && ny < b);
    }

    static class Node {
        int x,y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
