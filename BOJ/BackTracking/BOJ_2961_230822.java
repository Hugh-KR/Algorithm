package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2961_230822 {
    static int n;
    static ArrayList<Taste> list;
    static ArrayList<Integer> result;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        result = new ArrayList<>();
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Taste(s,b));
        }

        recur(0,1,0, 0);
        System.out.println(min);
    }

    static void recur(int idx, int s, int b, int use) {
        if (idx == n) {
            if (use == 0) return; // 아무 음식도 사용되지 않았다면

            min = Math.min(min, Math.abs(s-b));
            return;
        }

        recur(idx+1, s * list.get(idx).s, b + list.get(idx).b, use+1); // 재료를 사용한 경우
        recur(idx+1, s, b, use); // 재료를 사용하지 않은 경우
    }

    static class Taste {
        int s,b;

        public Taste(int s, int b) {
            this.s = s;
            this.b = b;
        }
    }

}
