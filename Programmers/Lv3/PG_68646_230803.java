package Programmers.Lv3;
import java.util.*;

/*
    09:20~10:38 (1차시 완료)
    09:20~14:16

    * DFS? *
    - 작은 걸 터트리는 경우와 큰 걸 터트리는 경우
    - 작은 걸 터트릴 수 있는 기회

    a길이 100만 (제곱 반복시 1조..)
    a의 수는 10억 이하
    a의 모든 수는 다르다

    규칙을 찾아라

    1. 오름차순 -> 모두 생존
    2. 내림차순 -> 모두 생존
    3. 가운데 기준 양쪽 작을 경우 -> 가운데 사망
    4. 가운데 기준 양쪽 클 경우 -> 모두 생존

    빈 공간 없도록 중앙으로 밀착 시킨다 -> Deque? 혹은 visited 처리

    1차 시도 53.3
    2차 시도 26.7
    3차 시도 100

    왼쪽으로 봤을때 최솟값 배열과
    오른쪽에서 봤을때 최솟값의 배열

    - 양쪽 끝의 풍선은 작은친구 터트릴 수 있는 무기를 가지고있다. (한쪽 방향만 신경쓰면 됨)
    - 양쪽에서 작은 값으로 갱신이 됐다는것은 뒷쪽은 다 터트릴 수 있다는것
*/
public class PG_68646_230803 {
    public int solution(int[] a) {
        int answer = 0;


        // if (a.length == 1) return 1;
        // if (a.length == 2) return 2;

//         ArrayList<Integer> leftMin = new ArrayList<>();
//         ArrayList<Integer> rightMin = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                answer++;
            }
        }

        min = Integer.MAX_VALUE;
        for (int i = a.length-1; i >= 0; i--) {
            if (min > a[i]) {
                min = a[i];
                answer++;
            }
        }

        // System.out.println(leftMin);
        // System.out.println(rightMin);


        return answer-1;
    }
}
