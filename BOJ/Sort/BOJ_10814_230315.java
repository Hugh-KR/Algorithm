package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10814_230315 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[][] arr = new String[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            arr[i][0] = age;
            arr[i][1] = name;
        }

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        for(String[] x:arr) {
            for(String z:x) {
                sb.append(z).append(" ");
            }
            sb.append("\n");
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
