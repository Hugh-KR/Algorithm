package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2563_230312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[100][100];
        int cnt = 0;

        for(int i = 0; i < n; i++){


            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int x = a; x < a + 10; x++){
                for(int y = b; y < b + 10; y++){
                    arr[x][y] = 1;
                }
            }



        }

        for(int[] x:arr){
            for (int z:x){
                if (z==1){
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }
}
