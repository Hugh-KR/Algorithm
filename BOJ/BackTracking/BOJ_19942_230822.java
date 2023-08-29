package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_19942_230822 {
    static int n;
    static int mp,mf,ms,mv;
    static ArrayList<Ingre> list;
    static int minCost = Integer.MAX_VALUE;
    static ArrayList<String> resultRoute = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken()); // 단백질
        mf = Integer.parseInt(st.nextToken()); // 지방
        ms = Integer.parseInt(st.nextToken()); // 탄수화물
        mv = Integer.parseInt(st.nextToken()); // 비타민

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken()); // 단백질
            int f = Integer.parseInt(st.nextToken()); // 지방
            int s = Integer.parseInt(st.nextToken()); // 탄수화물
            int v = Integer.parseInt(st.nextToken()); // 비타민
            int c = Integer.parseInt(st.nextToken()); // 비용
            list.add(new Ingre(p,f,s,v,c));
        }

        recur(0,0,0,0,0,0, "");
        if (minCost == Integer.MAX_VALUE) sb.append(-1);
        else {
            sb.append(minCost).append("\n");
            sb.append(resultRoute.get(resultRoute.size()-1));
        }

        System.out.println(sb);
    }

    // 식재료가 쓰이는 경우와 쓰이지 않는 경우로 나누기
    static void recur(int idx, int p, int f, int s, int v, int c, String route) {

        if (p >= mp && f >= mf && s >= ms && v >= mv) {
            if (minCost > c) {
                resultRoute.add(route);
                minCost = c;
            }
        }
        if (idx == n) { // 인덱스를 끝까지 순회하지 않아도 조건은 만족 할 수 있음
            return;
        }



        recur(idx+1, p+list.get(idx).p,f+list.get(idx).f,
                s+list.get(idx).s, v+list.get(idx).v, c+list.get(idx).c, ((route + (idx+1)) + " ")); // 식재료 쓰이는 경우
        recur(idx+1, p, f, s, v, c, route); // 쓰이지 않는경우
    }


    static class Ingre {
        int p,f,s,v,c;

        public Ingre(int p, int f, int s, int v, int c) {
            this.p = p;
            this.f = f;
            this.s = s;
            this.v = v;
            this.c = c;
        }
    }
}
