package Programmers;

public class PG_161988_230316 {
    static int[] arr = new int[]{2, 3, -6, 1, 3, -1, 2, 4};

    public static void main(String[] args) {


        System.out.println(solution(arr));
    }
    static long solution(int[] sequence) {

        long answer;
        long[] sum = new long[sequence.length + 1];
        long[] dp = new long[sequence.length + 1];
        long[] arr = new long[sequence.length];
        for(int i = 1; i < sum.length; i++) {
            if(i % 2 == 0) {
                sum[i] = (long) sequence[i - 1] * -1;
            } else {
                sum[i] = (long) sequence[i - 1];
            }
        }

        for(int i = 1; i < arr.length + 1; i++) {
            arr[i-1] = sum[i];

        }

        dp[0] = arr[0];
        long max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            System.out.println(dp[i]);
            max = Math.max(dp[i], max);

        }
        System.out.println(max);

        return -1;
    }


}
