package SWEA.Battle;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_17675_230711 {
    // 09:20~

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];
            graph = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                q.offer(c);
                graph.get(x).add(y);
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (dfs(i)) ans++;
            }






//            Collections.sort(list);
//
//            if(list.size() == 0) sb.append(String.format("#%d %d", tc, -1)).append("\n");
//            else sb.append(String.format("#%d %d", tc, list.get(0))).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static boolean dfs(int x) {
        if (visited[x]) {
            return false;
        }
        visited[x] = true;
        for (int val: graph.get(x)) {
            if (!visited[val]) {
                dfs(val);
            }
        }

        return true;
    }
}
