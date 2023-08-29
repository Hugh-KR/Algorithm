package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
    13:15~13:29

    *그리디*

    자격없는 친구는 선발도 안됐으니 빼라
 */
public class BOJ_1946_230807 {

    static class Node {
        int x,y;

        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
                if (o1.x == o2.x) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }));

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                pq.offer(new Node(x,y));
            }

            Node preNode = pq.poll();
            int pre_x = preNode.x;
            int pre_y = preNode.y;

            int cnt = 1;
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int x = node.x;
                int y = node.y;
                if (pre_x < x && pre_y < y) {
                    continue;
                }
                pre_x = x;
                pre_y = y;
                cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}
