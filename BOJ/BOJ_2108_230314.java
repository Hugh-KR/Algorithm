package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108_230314 {
    static int[] arr = new int[8001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0.0;
        int mode = 0; // 최빈값
        int median = 0; // 중앙값

        for(int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            sum += val;
            arr[val + 4000]++;

            if(max < val) {
                max = val;
            }
            if(min > val) {
                min = val;
            }
        }

        int count = 0;
        int mode_max = 0;
        boolean flag = false;

        for(int i = min + 4000; i <= max + 4000; i++) {
            if(arr[i] > 0) {

                /*
                 * <중앙값 찾기>
                 * 누적횟수가 전체 길이의 절반에 못 미친다면
                 */
                if(count < (n+1)/2) {
                    count += arr[i]; // i값의 빈도수를 count 에 누적
                    median = i - 4000;
                }
                /*
                 * <최빈값 찾기>
                 * 이전 최빈값보다 현재 값의 빈도수가 더 높을 경우
                 */
                if(mode_max < arr[i]) {
                    mode_max = arr[i];
                    mode = i - 4000;
                    flag = true;
                }
                // 이전 최빈값 최댓값과 동일한 경우면서 한 번만 중복되는 경우
                else if(mode_max == arr[i] && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }
        sb.append(Math.round(sum/n)).append("\n").append(median).append("\n");
        sb.append(mode).append("\n").append(max - min);
        System.out.println(sb);
    }

}
