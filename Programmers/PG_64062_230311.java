package Programmers;

public class PG_64062_230311 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    public static int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        L1:
        for(int i=0; i<stones.length-k+1; i++){
            int max = -1;
            for(int j=i; j<i+k; j++){
                if(answer<=stones[j]) {
                    i = j; // 현재까지 나온 최댓값 중 최솟값 이상의 값이 존재할 묶음들은 다 패스
                    continue L1;
                }
                if(max<stones[j])   max = stones[j];
            }
            if(answer>max)  answer = max;
        }
        return answer;
    }
}
