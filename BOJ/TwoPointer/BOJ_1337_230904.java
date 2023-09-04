package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    13:40~14:24 (44분)

    *투 포인터*

    - 올바른 배열 = 배열 속에 있는 원소 중 5개가 연속적인 것 (정렬했을 때 인접한 수 차이 1)
    - 올바른 배열이 되기위해 추가해야 할 원소의 개수 구하기
    - 10억보다 작거나 같은 음이 아닌 정수 (배열에 중복되는 수는 없음.)

    - 꼭 투포인터를 쓰지 않아도 괜찮을듯하다
    - 오히려 더 오래걸릴지도

    N <= 50
 */
public class BOJ_1337_230904 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        System.out.println(pro());

    }

    // 왼쪽 끝과 오른쪽 끝에서 시작해서 모든 원소의 탐색 방향 기준 추가해야 하는 값 확인
    // 반복을 줄이는 방향으로 생각
    static int pro() {
        int L = 0;
        int R = arr.length-1;

        int result = Integer.MAX_VALUE;
        while (L <= R) {
            result = Math.min(result, Math.min(searchArray(arr[L],L), searchArray(arr[R],R)));

            L++;
            R--;
        }

        return result;
    }

    static int searchArray(int num, int idx) {
        int cnt = 0;
        for (int i = num; i < num + 5; i++) {
            for (int j = idx; j < arr.length; j++) {
                if (i == arr[j]) cnt++;
            }
        }

        return 5 - cnt;
    }
}
