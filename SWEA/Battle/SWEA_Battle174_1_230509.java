package SWEA.Battle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
public class SWEA_Battle174_1_230509 {
    static int T;
    static String S, str1, str2;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            S = br.readLine();

            list = new ArrayList<>();
            str1 = "";
            str2 = "";

            // 각 자릿수별 더한 값 구하기
            SearchSum();

            // 최솟값 구하기 위한 sort
            Collections.sort(list);

            sb.append(String.format("#%d %d\n", i, list.get(0)));
        }
        System.out.println(sb);
    }

    static void SearchSum() {

        for (int j = 0; j < S.length() - 1; j++) {
            str1 += S.charAt(j);
            for (int k = j + 1; k < S.length(); k++) {
                str2 += S.charAt(k);
            }
            list.add(Integer.parseInt(str1) + Integer.parseInt(str2));
            str2 = "";
        }

    }
}
