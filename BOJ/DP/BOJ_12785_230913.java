package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    13:43~16:23

    *BFS -> DP*

    토쟁이가 학교에 늦지 않게 도착할 수 있는 등굣길의 개수 1,000,007로 나눈 나머지 값
 */
public class BOJ_12785_230913 {
    static int h,w; // 도시의 크기
    static int x,y; // 토스트 가게
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int mod = 1000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h+1][w+1];

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

//        map[x][y] = -1; // 토스트 가게 표시
        Node start = new Node(1,1);
        Node toast = new Node(x,y);
//        bfs(start, toast);

        long toToast = searchToast();
        long toSchool = searchSchool();

//        for (int i = 1; i <= h; i++) {
//            for (int j = 1; j <= w; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        if (w == x && h == y) {
            System.out.println((toToast) % mod);
        } else {
            System.out.println((toToast * toSchool) % mod);
        }

    }

    static int searchToast() {
        map[1][0] = 1;

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                map[i][j] = ((map[i-1][j] + map[i][j-1]) % mod);
            }
        }

        return map[y][x] % mod;
    }

    static int searchSchool() {
        map = new int[h+1][w+1];
        map[y][x-1] = 1;

        for (int i = y; i <= h; i++) {
            for (int j = x; j <= w; j++) {
                map[i][j] = ((map[i-1][j] + map[i][j-1]) % mod);
            }
        }

        return map[h][w] % mod;
    }

//    static void bfs(Node start, Node end) {
//        Queue<Node> q = new LinkedList<>();
//        boolean[][] visited = new boolean[h+1][w+1];
//        visited[start.x][start.y] = true;
//        q.offer(start);
//
//        while (!q.isEmpty()) {
//            Node now = q.poll();
//            int x = now.x;
//            int y = now.y;
//
//            if (x == end.x && y == end.y) {
//                break;
//            }
//
//            for (int i = 0; i < 4; i++) {
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//
//                if (isRange(nx,ny) && !visited[nx][ny]) {
//                    map[nx][ny] = map[x][y] + 1;
//                    q.offer(new Node(nx,ny));
//                    visited[nx][ny] = true;
//                }
//            }
//
//        }
//
//    }

    static boolean isRange(int nx, int ny) {
        return (nx >= 1 && ny >= 1 && nx <= h && ny <= w);
    }

    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
