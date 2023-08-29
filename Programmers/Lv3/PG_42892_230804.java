package Programmers.Lv3;
import java.util.*;

/*
    10:07~16:18
    (블로그 참조)

    * DFS? *

    - 이진트리
    - 오른쪽 서브트리가 채워지면 끝

    트리의 깊이가 1000 이하인 경우만 입력으로 주어짐
    nodeinfo 길이 1 이상 10000 이하

    배열에 넣고 순회하면 층을 만들 수 있음

    0 부터 pre_y 까지,  pre_y
    pre_y 가기전에 오른쪽 sub만나면 다음녀석으로
    그게 아니면 pre_y 까지

    - 트리 개념 익히기
    - 전위순회(preorder)
    - 중위순회(inorder)
    - 후위순회(postorder)

    1차 시도 100

*/



public class PG_42892_230804 {
    static int idx;
    static int[][] result;
    static class Node {
        int num;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int num, int x, int y, Node left, Node right) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        // 노드 입력
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o2.y == o1.y) {
                return o1.x - o2.x;
            }
            return o2.y - o1.y;
        });

        //트리 만들기
        Node root = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            insertNode(root, list.get(i));
        }

        result = new int[2][list.size()];

        //전위순회
        idx = 0;
        preorder(root);

        //후위순회
        idx = 0;
        postorder(root);

        return result;
    }

    // 트리 만들기
    private static void insertNode(Node parent, Node child) {
        if (parent.x > child.x) { // 왼쪽 자식인 경우
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child); // 비어있지 않다면 왼쪽을 부모 삼아서 한번 더 돌아
        } else { // 오른쪽 자식인 경우
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child); // 비어있지 않다면 왼쪽을 부모 삼아서 한번 더 돌아
        }
    }

    //전위순회
    private static void preorder(Node root) {
        if (root != null) {
            result[0][idx++] = root.num;
            preorder(root.left);
            preorder(root.right);
        }
    }

    //후위순회
    private static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            result[1][idx++] = root.num;
        }
    }

}
