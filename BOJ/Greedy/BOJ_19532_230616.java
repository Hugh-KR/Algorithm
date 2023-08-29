package BOJ.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19532_230616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if ((a*i) + (b*j) == c && (d*i) + (e*j) == f) {
                    sb.append(i + " " + j);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
