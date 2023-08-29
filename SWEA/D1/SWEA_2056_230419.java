package SWEA.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2056_230419 {
    static int num = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        while (T-- > 0) {
            String calender = br.readLine();

            int year = Integer.parseInt(calender.substring(0, 4));
            int month = Integer.parseInt(calender.substring(4, 6));
            int day = Integer.parseInt(calender.substring(6, 8));

            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                if (1 <= day && day <= 31) {
                    sb.append(String.format("#" + num + " %04d/%02d/%02d\n", year, month, day));
                } else {
                    sb.append("#" + num + " -1\n");
                }
                num++;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (1 <= day && day <= 30) {
                    sb.append(String.format("#" + num + " %04d/%02d/%02d\n", year, month, day));
                } else {
                    sb.append("#" + num + " -1\n");
                }
                num++;
            } else if (month == 2) {
                if (1 <= day && day <= 28) {
                    sb.append(String.format("#" + num + " %04d/%02d/%02d\n", year, month, day));
                } else {
                    sb.append("#" + num + " -1\n");
                }
                num++;
            } else {
                sb.append("#" + num + " -1\n");
                num++;
            }

        }

        System.out.println(sb);
    }
}
