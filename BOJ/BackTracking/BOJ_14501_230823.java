package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_14501_230823 {
    static int n;
    static int maxResult = Integer.MIN_VALUE;
    static ArrayList<Shedule> list = new ArrayList<>();
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list.add(new Shedule(t,p));
        }
        System.out.println(findBestPlan(0));
//        System.out.println(maxResult);
//        for(int i = 0; i <= n; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        Collections.sort(list, (o1,o2) -> {
//            if (o1.t == o2.t) {
//                return o1.p - o2.p;
//            }
//            return o1.t - o2.t;
//        });

//        int day = 0;
//        int pay = 0;
//        for (Shedule she : list) {
//            day += she.t;
//            if (day > (n+1)) break;
//            pay += she.p;
//        }

//        System.out.println(pay);
    }

    // 그날 일을 하는 경우와 하지 않는 경우
    // 조건 처리가 까다로움
    static int findBestPlan(int idx) {

        if (idx == n) { // 일단 n-1일 만큼은 일을 해야함 (list 인덱스 0부터 시작)
//            if (maxResult < p) maxResult = p; // 급여 최대값 갱신
            return 0;
        }
        if (idx > n) return Integer.MIN_VALUE; // n+1 일의 경우 퇴사 (list 인덱스 범위 밖)
        if (dp[idx] > 0) return dp[idx]; // 이미 값이 들어있다면 들어있는 값 리턴

        dp[idx] = Math.max(findBestPlan(idx+(list.get(idx).t)) + list.get(idx).p, findBestPlan(idx+1));
//        findBestPlan(idx+1, p); // 하지 않는 경우

        return dp[idx]; // 현재 값 다음으로 넘겨줌
    }
    static class Shedule {
        int t,p;

        public Shedule(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }
}
