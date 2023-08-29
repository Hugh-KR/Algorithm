package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(isPalindrome(str));
    }

    static int isPalindrome(String str){
        if (str == null)
            return 0;

        for (int i = 0, j = str.length() - 1; i <= j; i++, j--){
            if (str.charAt(i) != str.charAt(j)){
                return 0;
            }
        }
        return 1;
    }
}
