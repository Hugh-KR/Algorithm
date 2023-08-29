package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2798_230319 {
    static int[] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(BlackJack(n,m));

    }

    static int BlackJack(int n, int m) {
        int result = 0;
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int z = j + 1; z < n; z++) {
                    int temp = arr[i] + arr[j] + arr[z];

                    if(temp == m) {
                        return temp;
                    }

                    if(result < temp && temp < m) {
                        result = temp;
                    }
                }
            }
        }
        return result;
    }
}
