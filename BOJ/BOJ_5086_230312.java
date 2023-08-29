package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5086_230312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0){
                break;
            }


            if (b % a == 0){                     // 첫 번째 숫자가 두 번째 숫자의 약수이다.
                System.out.println("factor");
            }else if(a % b == 0){                //첫 번째 숫자가 두 번째 숫자의 배수이다.
                System.out.println("multiple");
            }else{                               //첫 번째 숫자가 두 번째 숫자의 약수와 배수 모두 아니다.
                System.out.println("neither");
            }

        }
    }
}
