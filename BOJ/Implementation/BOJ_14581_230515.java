package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14581_230515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String id = br.readLine();

        sb.append(String.format(":fan::fan::fan:\n" +
                                ":fan::%s::fan:\n" +
                                ":fan::fan::fan:", id));
        System.out.println(sb);
    }
}
