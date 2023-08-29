package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2566_230310 {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[9][9];

        for(int i = 0; i < arr.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] x : arr){
            for (int y : x){
                if (max < y){
                    max = y;
                }
            }
        }

        System.out.println(max);
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == max){
                    System.out.println((i + 1) + " " + (j + 1));
                    break;
                }
            }
        }
    }
}
