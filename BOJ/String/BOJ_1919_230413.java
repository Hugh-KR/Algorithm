package BOJ.String;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1919_230413 {
    static int[] arr1 = new int[26];
    static int[] arr2 = new int[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        for (int i = 0; i < str1.length(); i++) {
            arr1[((int)str1.charAt(i)) - 97] += 1;

        }
        for (int i = 0; i < str2.length(); i++) {
            arr2[((int)str2.charAt(i)) - 97] += 1;
        }

        int cnt = 0;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                cnt += (Math.abs(arr1[i] - arr2[i]));
            }
        }

        System.out.println(cnt);
    }
}
