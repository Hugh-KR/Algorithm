package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    * 반드시 3이 들어가야함
    - 전체 합이 3으로 나누어 떨어질것
    - 전체 합을 3으로 나눈값 >= 홀수개수
 */
public class BOJ_19539_230729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int oddCnt = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int tree = Integer.parseInt(st.nextToken());
            sum += tree;
            if (tree % 2 == 1) oddCnt++;
        }

        if (sum % 3 == 0 && sum / 3 >= oddCnt) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
