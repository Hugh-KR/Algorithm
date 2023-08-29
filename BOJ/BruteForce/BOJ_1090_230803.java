package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    23.08.03 21:50~
    23.08.04 21:55

    결국 블로그 참고하여 해결.
    약 24시간 걸림 (물론 여러가지를 병행..) 예제는 통과 했지만,
    모든 경우의 수를 고려하지 않아 통과하지 못한듯.

    * 완전탐색 *
    (직관적으로 어떻게 풀 수 있을까)

    N 50이하
    값 100만 이하

    - 체커 하나씩 최소 횟수를 구해가기
    - 1번에 맞춰보고 2번에 맞춰보고 X (무차별 대입을 한다..?)
    - 각각의 중간 값에 맞춘다?
    - 모든 x,y의 최소거리?
 */

class Checker {
    int x;
    int y;

    public Checker(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ_1090_230803 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        ArrayList<Checker> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Checker(x, y));
        }

//        //리스트 정렬
//        Collections.sort(list , ((o1, o2) -> {
//            if (o1.x == o2.x) { //x 값이 같으면
//                return o1.y - o2.y; //y 내림차순 정렬
//            }
//            return o1.x - o2.x; //아니면 x 오름차순 정렬
//        }));

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Checker checkerI = list.get(i);
                Checker checkerJ = list.get(j);
                int curx = checkerI.x;
                int cury = checkerJ.y;

                int[] sumArr = new int[n];
                for (int k = 0; k < n; k++) {
                    Checker minChecker = list.get(k);
                    int sum = Math.abs(curx - minChecker.x) + Math.abs(cury - minChecker.y);
//                    System.out.println("현재 x y sum : " + curx + " " + cury + " " + sum);
                    sumArr[k] = sum;
                }
                Arrays.sort(sumArr);
                //누적합?
                for (int k = 1; k < n; k++) {
                    sumArr[k] += sumArr[k-1];
//                    System.out.println(sumArr[k]);
                }

                //초기값 설정
                if (i == 0 && j == 0) {
                    for (int k = 0; k < n; k++) {
                        result[k] = sumArr[k];
                    }
                }

                //초기값 아닐경우 최솟값 갱신
                for (int k = 0; k < n; k++) {
                    result[k] = Math.min(result[k], sumArr[k]);
                }
            }
        }

        for (int val : result) {
            sb.append(val + " ");
        }
        System.out.println(sb.toString());
    }
}
