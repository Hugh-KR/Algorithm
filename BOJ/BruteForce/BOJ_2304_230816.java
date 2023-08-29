package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2304_230816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Node> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list.add(new Node(l,h));
        }
        Collections.sort(list, (o1, o2) -> o1.pos - o2.pos);

        int result = 0;
        int maxHeightIdx = 0;
        Node preNode = list.get(0);
        for (int i = 1; i < list.size(); i++) { // 왼쪽 반복문
            Node nowNode = list.get(i);

            if (preNode.height <= nowNode.height) {
                result += (nowNode.pos - preNode.pos) * preNode.height;
                preNode = nowNode;
                maxHeightIdx = i;
            }

        }

        preNode = list.get(list.size()-1);
        for (int i = 1; i < list.size()-maxHeightIdx; i++) { // 왼쪽 반복문
            Node nowNode = list.get(list.size()-1-i);

            if (preNode.height <= nowNode.height) {
                result += (preNode.pos - nowNode.pos) * preNode.height;
                preNode = nowNode;
            }

        }
        System.out.println(result + list.get(maxHeightIdx).height);
    }

    static class Node {
        int pos,height;

        public Node(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }
    }
}
