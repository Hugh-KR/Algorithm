package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_230902 {
    static int n;
    static ArrayList<Integer>[] tree;
    static int[] par;
    static boolean[] visited;
//    static int[] chi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

//        chi = new int[n+1];
        par = new int[n+1];
        visited = new boolean[n+1];

        tree = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }


        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 인접 리스트
            tree[a].add(b);
            tree[b].add(a);
        }

        recur(1, 0);

        for (int i = 2; i <= n; i++) {
            sb.append(par[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void recur(int node, int pre) { // 여기서는 몇개든 붙을 수 있음
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        par[node] = pre; // 부모가 자식에게 영향 주려면 위에 배치 하면 됨.

        for (int val : tree[node]) {
            if (val == pre) continue; // 역주행 하지 못하도록
            recur(val, node);
        }

//        chi[pre] += 1; // 자식이 부모에게 영향 주려면 아래 배치

    }
}
