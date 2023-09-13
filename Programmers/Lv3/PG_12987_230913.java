package Programmers.Lv3;

import java.util.*;

/*
    13:08~13:39

    *이분탐색(Upper_Bound)*

    - 2*N명의 사원들 N명씩 두 팀으로 나눠 숫자 게임을 함 각각 A팀 B팀
    - 모든 사원 무작위 자연수 하나씩 부여받음
    - 한번씩 경기
    - A팀 B팀에서 한 사원이 나와 서로의 수 공개, 그때 숫자가 큰 쪽이 승리 -> 승리팀 1점 추가
    - 숫자 같으면 무효

    B팀이 가장 높은 승점을 얻는 방법으로 출전 순서 정함. -> 이때 B팀이 얻는 승점은?

    A,B 길이 1이상 10만 이하.
    A,B 각 원소 1이상 10억 이하.

    * 완탐은 안됨

    가장 큰 값을 위해서는 원소 하나가 자기보다 큰값중 가장 작은 값을 얻어야 함.
    Upper_bound


    1차 시도 - 28.6
    2차 시도 - 성공

*/
public class PG_12987_230913 {
    static ArrayList<Integer> list = new ArrayList<>();
    static int result = 0;

    public int solution(int[] A, int[] B) {
        int answer = -1;
        for (int val : B) {
            list.add(val);
        }
        Collections.sort(list);
        // System.out.println(list);

        for (int val : A) {
            int idx = binarySearch(val);
            if (list.get(idx) > val) {
                list.remove(idx);
                result++;
            }
            // System.out.println(list.get(idx));

        }

        return result;
    }

    static int binarySearch(int target) {
        int L = 0;
        int R = list.size() - 1;

        while (L < R) {
            int mid = (L+R)/2;

            if (list.get(mid) <= target) {
                L = mid+1;
            } else {
                R = mid;
            }
        }

        return R;
    }
}
