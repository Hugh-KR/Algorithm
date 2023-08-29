package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15666_230405 {
    static int N,M;
    static ArrayList<Integer> exam = new ArrayList<>();
    static ArrayList<Integer> re_exam;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            exam.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>(exam);
        re_exam = new ArrayList<>(set);
        Collections.sort(re_exam);

        N -= (exam.size() - re_exam.size());

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int val : result) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            result[depth] = re_exam.get(i);
            dfs(i, depth + 1);
        }
    }
}
