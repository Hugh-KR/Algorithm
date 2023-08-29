package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3029_230402 {
    static int[] result = new int[3];
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arrive = new int[3];
        int[] start = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            arrive[i] = Integer.parseInt(st.nextToken(":"));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            start[i] = Integer.parseInt(st.nextToken(":"));
        }

        if (Arrays.equals(arrive, start)) {
            System.out.println("24:00:00");
        } else {
            WaitTime(arrive, start);
            System.out.format("%02d:%02d:%02d", result[0], result[1], result[2]);
        }


    }

    static void WaitTime(int[] arrive, int[] start) {

        for (int i = 0; i < 3; i++) {
            result[i] = start[i] - arrive[i];
        }

        if (result[2] < 0) {
            result[2] += 60;
            --result[1];
        }
        if (result[1] < 0) {
            result[1] += 60;
            --result[0];
        }
        if (result[0] < 0) {
            result[0] += 24;
        }

    }
}
