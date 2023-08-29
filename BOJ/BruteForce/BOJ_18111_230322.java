package BOJ.BruteForce;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18111_230322 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(max < arr[i][j]) max = arr[i][j];
                if(min > arr[i][j]) min = arr[i][j];
            }
        }

        int time = Integer.MAX_VALUE;
        int high = 0;

        for(int i = min; i <= max; i++) {
            int cnt = 0;
            int block = b;

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(i < arr[j][k]) {
                        cnt += (arr[j][k] - i) * 2;
                        block += (arr[j][k] - i);
                    } else {
                        cnt += (i - arr[j][k]);
                        block -= (i - arr[j][k]);
                    }
                }
            }
            // 블록 개수 음수이면 반복문 종료
            if(block < 0) break;

            if(time >= cnt) {
                time = cnt;
                high = i;
            }
        }

        System.out.println(time + " " + high);
    }
}
