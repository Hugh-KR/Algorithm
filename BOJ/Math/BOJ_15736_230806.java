package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    20:30~21:12
    (힌트 참조)

    *정수론(수학?)*

    1 <= N <= 21억
    - 시간초과 유의 (1초에 1억)
    - 제곱수만 남는다..?

    결국 전부 백색인 상태로 시작한다는거잖아?
    방문하면 깃발 색 바뀜
    규칙 찾기
    이것이 정수론인가..
 */
public class BOJ_15736_230806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (i*i > n) break; // 남을 제곱수 확인
            else result++;
        }

        System.out.println(result);
    }
}
