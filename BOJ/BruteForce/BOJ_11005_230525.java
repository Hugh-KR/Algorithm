package BOJ.BruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11005_230525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(N, B).toUpperCase());
        bw.flush();
        bw.close();
    }
}
