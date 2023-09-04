package BOJ.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
    13:03~13:37

    *트리*

    - 같은 키를 가지는 노드는 없음
    - 트리의 전위 순회 결과를 보고 후위 순회로 변경
    - 이진트리는 루트를 기준으로 왼쪽 오른쪽
    - 전위 순회는 루트가 먼저 나온다
    - 필요하다면 메서드 분리하며 풀어보자

 */
public class BOJ_5639_230904 {

    static class Node {
        int node;
        Node left,right;

        public Node (int node) {
            this.node = node;
        }

        public void insert(int input) {
            if (this.node > input) { // 인풋값이 노드보다 작다면 -> 왼쪽으로 붙임
                if (this.left == null) this.left = new Node(input); // 왼쪽 값이 비었다면 바로 붙임
                else this.left.insert(input); // 비어있지 않다면 left 기준으로 한번 더 연산
            }

            else if (this.node < input) { // 오른쪽
                if (this.right == null) this.right = new Node(input);
                else this.right.insert(input);
            }
        }
    }


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node node = new Node(Integer.parseInt(br.readLine())); // 노드에 왼쪽 오른쪽 추가하는 형식
        while (true) {
            String inputData = br.readLine();
            if (inputData == null || inputData.equals("")) break;

            node.insert(Integer.parseInt(inputData));
        }

        // 후위 순회 결과 출력
        postOrder(node);
        System.out.println(sb);
    }

    static void postOrder(Node node) {

        if (node.left != null) postOrder(node.left);
        if (node.right != null) postOrder(node.right);
        sb.append(node.node).append("\n");

    }
}
