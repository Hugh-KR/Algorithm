package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18870_230315 {
    static int[] arr;
    static int[] sortedArr;
    static HashMap<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        sortedArr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            sortedArr[i] = x;
        }
        Arrays.sort(sortedArr);

        int rank = 0;
        for(int x: sortedArr) {
            if(!map.containsKey(x)) {
                map.put(x, rank);
                rank++;
            }
        }

        for(int z: arr) {
            sb.append(map.get(z)).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }
}
