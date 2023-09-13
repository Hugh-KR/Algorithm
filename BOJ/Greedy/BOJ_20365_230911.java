package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
    13:55~14:12 (17분)

    *그리디*

    - 더 많은 컬러 기준으로 잡아보자.
    - 연속된 더 작은 컬러 개수 + 1
 */
public class BOJ_20365_230911 {
    static int n;
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        str = br.readLine();

        System.out.println(1 + selectColor());
    }

    static int selectColor() {
        int red = 0;
        int blue = 0;

        char pre = '0';
        for (int i = 0; i < n; i++) {
            char color = str.charAt(i);

            if (color != pre) { // 컬러가 다르면
                if (color == 'B') blue++;
                else red++;
            }

            pre = color; // 컬러 갱신
        }

        System.out.println("blue: " + blue + "\n" + "red: " + red);

        return Math.min(red, blue);
    }


}
