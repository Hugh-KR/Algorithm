package Programmers.Lv2;
import java.util.*;

/*
    14:27~

    *BFS*

    - X는 바다 숫자는 무인도를 나타냄
    - 상 하 좌 우 연결되는 땅은 하나의 무인도를 이룸
    - 숫자는 식량을 나타내고 상 하 좌 우 연결되는 칸에 적힌 숫자 모두 합한 값은
      해당 무인도에서 최대 몇일간 머물 수 있는지 나타냄

    - 각 섬에서 최대 몇일씩 머무를 수 있는지 출력
    - 무인도 없으면 -1

    X를 0으로 두고 진행

*/
public class PG_154540_230906 {
    static int[][] arr;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> solution(String[] maps) {
        int[] answer = {};

        arr = new int[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') arr[i][j] = 0;
                else arr[i][j] = c - '0';
            }
            // System.out.println(maps[i]);
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (arr[i][j] > 0 && !visited[i][j]) {
                    list.add(bfs(i,j));
                }

                // System.out.print(arr[i][j]);
            }
            // System.out.println();
        }
        Collections.sort(list);
        if (list.size() == 0) list.add(-1);

        return list;
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(x,y));
        visited[x][y] = true;

        int sum = arr[x][y];
        while(!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (isRange(nx,ny) && !visited[nx][ny] && arr[nx][ny] > 0) {
                    q.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                    sum += arr[nx][ny];
                }
            }
        }

        return sum;
    }

    static boolean isRange(int nx, int ny) {
        return (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length);
    }

    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
