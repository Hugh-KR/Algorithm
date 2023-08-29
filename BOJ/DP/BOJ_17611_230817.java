package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    13:50~16:24 (2시간 34분)

    "누적합"
    (이모스법)

    - 모든 x 좌표를 0으로 보고 하나씩 장애물 세워가며 진행
    - 가장 큰
    - 수평선 H는 다각형의 어떤 수평선분과도 겹쳐 놓여선 안됨, 수직선 V는 다각형의 어떤 수직선분과도 겹쳐 놓여서는 안됨.

    처음 나온 점과 두번째 점 비교하여 x축 다르다면 x축과 평행한 선분, y축 다르다면 y축 평행한 선분이다.

    x축 y축을 각각 직선으로 보고 선분을 그어 이모스법 활용, 누적합 구해서 진행.
 */
public class BOJ_17611_230817 {
    static int[] sumX = new int[1000002];
    static int[] sumY = new int[1000002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Node(x + 500000, y + 500000));
        }

        for (int i = 0; i < n; i++) {
            Node now = list.get(i);
            Node next = list.get((i+1)%n);

            if (now.y == next.y) {
                sumY[Math.min(now.x, next.x)]++;
                sumY[Math.max(now.x, next.x)]--;
            } else {
                sumX[Math.min(now.y, next.y)]++;
                sumX[Math.max(now.y, next.y)]--;
            }
        }

        int maxSumX = sumX[0];
        int maxSumY = sumY[0];
        for (int i = 1; i < 1000002; i++) {
            sumX[i] += sumX[i-1];
            sumY[i] += sumY[i-1];

            maxSumX = Math.max(maxSumX, sumX[i]);
            maxSumY = Math.max(maxSumY, sumY[i]);
        }

        System.out.println(Math.max(maxSumX, maxSumY));
    }

    static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
