package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869_230926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        System.out.println(pro(a,b,v));
    }

    private static int pro(int a, int b, int v) {
        int day = (v - a) / (a-b);
        if (((v - a) % (a-b)) == 0) day+=1;
        if (((v - a) % (a-b)) != 0) day+=2;
        return day;
    }
}
