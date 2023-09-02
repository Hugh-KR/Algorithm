package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1991_230901 {
    static int n;
    static ArrayList<Integer>[] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        tree = new ArrayList[27];
        for (int i = 1; i <= 26; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'A' + 1;
            int b = st.nextToken().charAt(0) - 'A' + 1;
            int c = st.nextToken().charAt(0) - 'A' + 1;

            tree[a].add(b);
            tree[a].add(c);
//            System.out.println(a + " " + b + " " + c);
        }

        preOrder(1);
        sb.append("\n");
        inOrder(1);
        sb.append("\n");
        postOrder(1);

        System.out.println(sb);
    }

    // 전위 순회
    static void preOrder(int node) {
        if (node == -18) {
            return;
        }
        sb.append((char)((node-1)+'A'));
        preOrder(tree[node].get(0));
        preOrder(tree[node].get(1));
    }

    // 중위 순회
    static void inOrder(int node) {
        if (node == -18) {
            return;
        }

        inOrder(tree[node].get(0));
        sb.append((char)((node-1)+'A'));
        inOrder(tree[node].get(1));
    }

    // 후위 순회
    static void postOrder(int node) {
        if (node == -18) {
            return;
        }

        postOrder(tree[node].get(0));
        postOrder(tree[node].get(1));
        sb.append((char)((node-1)+'A'));
    }

}
