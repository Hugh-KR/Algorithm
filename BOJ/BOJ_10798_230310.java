package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798_230310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] arr = new char[5][15];
        int max = 0;

        for(int i = 0; i < arr.length; i++){
            String str = br.readLine();
            if (max < str.length()) max = str.length();

            for (int j = 0; j < str.length(); j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < max; i++){
            for (int j = 0; j < arr.length; j++){
                if(arr[j][i] == '\0') continue;
                sb.append(arr[j][i]);
            }

        }

        System.out.println(sb);

    }
}
