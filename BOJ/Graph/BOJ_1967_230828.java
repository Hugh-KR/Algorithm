package BOJ.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    14:42~16:56

    *BF,DFS*

    - 양방향 인접 리스트

 */
public class BOJ_1967_230828 {
    static int n;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int j = 0; j < n-1; j++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 양방향 인접 리스트
            list[a].add(new Node(b,weight));
            list[b].add(new Node(a,weight));
        }

        for (int i = 1; i <= n; i++) { // 모든 노드에서 탐색 진행
//            visited = new boolean[n+1];

            // visited 갱신 해주지 않는다면 백트래킹 해야함
            visited[i] = true;
            dfs(i,0);
            visited[i] = false;
        }

//        visited[1] = true;
//        dfs(1,0);
        System.out.println(max);

    }

    static void dfs(int start, int sum) {

        if (max < sum) {
            max = Math.max(max, sum);
        }

        for (Node node : list[start]) {
            if (!visited[node.idx]){
                visited[node.idx] = true;
                dfs(node.idx, sum + node.weight);
                visited[node.idx] = false;
            }
        }

    }

    static class Node {
        int idx, weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

}
