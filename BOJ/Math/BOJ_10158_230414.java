package BOJ.Math;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10158_230414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int result = Integer.parseInt(br.readLine());

        int resultX = (result + x) % (W * 2);
        int resultY = (result + y) % (H * 2);

        if (resultX > W) resultX = (W * 2) - resultX;
        if (resultY > H) resultY = (H * 2) - resultY;

        bw.write(resultX + " " + resultY);

        bw.flush();
        bw.close();
    }
}
