package BOJ.Sort;

import java.util.*;
import java.io.*;

public class BOJ_1717_230421 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        // union find: 2개의 노드의 부모 노드를 확인해여 현재 같은 집합에 속하는지 확인하는 알고리즘
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (query == 0)
                union(a, b);
            else {
                if (find(a) == find(b))
                    bw.append("YES\n");
                else
                    bw.append("NO\n");
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static int find(int num) {
        if (arr[num] == num)
            return num;
        return arr[num] = find(arr[num]);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b)
            arr[b] = a;
        else
            arr[a] = b;
    }
}
