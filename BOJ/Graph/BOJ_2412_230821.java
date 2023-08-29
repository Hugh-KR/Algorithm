package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    10:30~13:50

    *BFS*


    절대값으로 앞 뒤 가능
    |a - x| <= 2
    |b - y| <= 2

    y = T 일때 까지의 암벽 등반
    이동 횟수 최소로 하면서 정상에 오르기
    오를때 x 좌표는 아무 곳이나 되어도 상관이 없다 (재방문 가능)

    - 정상에 오를 수 없으면 -1 출력
    - 유닛 단위로 클리어하며 진행

 */
public class BOJ_2412_230821 {
    static int n,t;
//    static int[][] map;
//    static int[][] visited;
    static ArrayList<Integer>[] list; // 이차원 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        list = new ArrayList[200001];
        for (int i = 0; i < 200001; i++) { // 이차원 리스트 초기화
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
//            map[x][y] = 1;
            list[y].add(x);
        }

        for (int i = 0; i < 200001; i++) {
            Collections.sort(list[i]);
//            System.out.println(list[i]);
        }

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0)); // 시작 값

        int moveCnt = 0;
        while(!q.isEmpty()) {
            int size = q.size(); // 유닛 단위로 클리어
            for (int i = 0; i < size; i++) {
                Node now = q.poll();
                if (now.y == t) return moveCnt;
                for (int y = now.y - 2; y <= now.y + 2; y++) {
                    if (0 > y || y > 200000) continue;

                    for (int j = 0; j < list[y].size(); j++) {
                        int x = list[y].get(j);
                        if (x > now.x + 2) break; // 현재 위치보다 방문할 위치가 범위보다 큰 경우 종료 (오름차순 정렬함)
                        else if (now.x - 2 > x) continue;

                        // 통과 했다면 이동 가능한 좌표
                        list[y].remove(j);
                        q.offer(new Node(x, y));
                        j--; // 인덱스 컨트롤
                    }
                }
            }
            moveCnt++;
        }
        return -1;
    }

    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
