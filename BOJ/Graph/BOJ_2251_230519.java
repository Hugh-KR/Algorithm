package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2251_230519 {
    static int volume[] = new int[3];
    static boolean c_visited[] = new boolean[201];
    static boolean visited[][][] = new boolean[201][201][201];
    static ArrayList<Integer> ans_list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int a,b,c;
        Node (int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        volume[0] = Integer.parseInt(st.nextToken());
        volume[1] = Integer.parseInt(st.nextToken());
        volume[2] = Integer.parseInt(st.nextToken());

        BFS();
        Collections.sort(ans_list);
        for (int i = 0; i < ans_list.size(); i++) {
            sb.append(ans_list.get(i) + " ");
        }
        System.out.println(sb);
    }

    static void BFS() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, volume[2]));
        visited[0][0][volume[2]] = true;

        while(!q.isEmpty()) {
            Node n = q.poll();
            if (n.a == 0 && !c_visited[n.c]) {
                ans_list.add(n.c);
                c_visited[n.c] = true;
            }
            if (n.a != 0) {
                for (int i = 0; i < 2; i++) {
                    Node new_n;
                    if (i == 0) new_n = pourWater(n, 0, 1);
                    else new_n = pourWater(n, 0, 2);
                    // 방문 검사
                    if (!visited[new_n.a][new_n.b][new_n.c]) {
                        q.add(new_n);
                        visited[new_n.a][new_n.b][new_n.c] = true;
                    }

                }
            }
            if (n.b != 0) {
                for (int i = 0; i < 2; i++) {
                    Node new_n;
                    if (i == 0) new_n = pourWater(n, 1, 0);
                    else new_n = pourWater(n, 1, 2);
                    // 방문 검사
                    if (!visited[new_n.a][new_n.b][new_n.c]) {
                        q.add(new_n);
                        visited[new_n.a][new_n.b][new_n.c] = true;
                    }

                }
            }
            if (n.c != 0) {
                for (int i = 0; i < 2; i++) {
                    Node new_n;
                    if (i == 0) new_n = pourWater(n, 0, 1);
                    else new_n = pourWater(n, 2, 1);
                    // 방문 검사
                    if (!visited[new_n.a][new_n.b][new_n.c]) {
                        q.add(new_n);
                        visited[new_n.a][new_n.b][new_n.c] = true;
                    }

                }
            }
        }

    }

    static Node pourWater(Node n, int from, int to) {
        int arr[] = {n.a, n.b, n.c};
        arr[to] += arr[from];
        arr[from] = 0;

        if (arr[to] > volume[to]) {
            arr[from] = arr[to] - volume[to];
            arr[to] = volume[to];
        }
        return new Node(arr[0], arr[1], arr[2]);
    }

}


