package BOJ.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717_230829 {
    static int n,m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (k == 0) {
                _union(a,b);
            } else {
                if (_find(a) == _find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    static void _union(int a, int b) { // Rank: 최대 높이 확인해서 합쳐줘라
        a = _find(a); // 조상에 합쳐라
        b = _find(b);
        arr[a] = b;
    }
    static int _find(int a) {
        if (arr[a] == a) return a; // 루트노드라면
        else {
            arr[a] = _find(arr[a]);
            return _find(arr[a]);
        }
    }
}
