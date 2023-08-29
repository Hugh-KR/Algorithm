package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    09:44~

    *구현*

    왼쪽 최대벽과 오른쪽 최대벽을 구해줌
 */
public class BOJ_14719_230817 {
    static int h,w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }

        int result = 0; // 고인 빗물의 합

        for (int i = 1; i < w-1; i++) {
            int leftMax = list.get(i);
            int rightMax = list.get(i);

            for (int j = i-1; j >= 0; j--) { // 현재 인덱스 기준 왼쪽 큰값
                leftMax = Math.max(leftMax, list.get(j));
            }

            for (int j = i+1; j < w; j++) { // 현재 인덱스 기준 오른쪽 큰값
                rightMax = Math.max(rightMax, list.get(j));
            }

            if (Math.min(leftMax,rightMax) > list.get(i)) { // 현재 높이보다 높은 벽이 있을 경우
                result += (Math.min(leftMax,rightMax) - list.get(i));
            }

        }

        System.out.println(result);
    }
}
