package Programmers.Lv2;

public class PG_17679_230729 {
    static int[] dx = {0, 0, 1, 1};
    static int[] dy = {0, 1, 1, 0};

    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};

        System.out.println(solution(6,6,board));
    }
    static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];

        for (int i = 0; i < m; i++) {
            arr[i] = board[i].toCharArray();
        }
        int cnt = 0;
        boolean[][] visited = new boolean[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {

                for (int idx = 0; idx < 4; idx++) {
                    int nx = x + dx[idx];
                    int ny = y + dy[idx];

                    if (isRange(nx, ny, m, n) && !visited[nx][ny] && arr[x][y] == arr[nx][ny]) {

                        for (int idx2 = 0; idx2 < 4; idx2++) {
                            int mx = nx + dx[idx2];
                            int my = ny + dy[idx2];

                            if (isRange(mx, my, m, n) && !visited[mx][my] && arr[nx][ny] == arr[mx][my]) {
                                visited[mx][my] = true;
                                cnt++;
                            }
                        }
                    }
                }


            }
        }

        return cnt;
    }

    static boolean isRange(int nx, int ny, int m, int n) {
        return (nx >= 0 && ny >= 0 && nx < m && ny < n);
    }
}
