package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_230320 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] n_Arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            n_Arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] m_Arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < m; j++) {
            m_Arr[j] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(n_Arr);
        Arrays.sort(m_Arr);

        int front = 0;
        int rear = n;
        int mid = n / 2;

        for(int i = 0; i < n; i++) {
            if(m_Arr[i] == n_Arr[mid]) {
                m_Arr[i] = 1;
            }
        }

        for(int x:m_Arr){
            if(x == 1) sb.append(x).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);

    }
}
