package BOJ.Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375_230405 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            HashMap<String,Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                if (map.containsKey(kind)) {
                    map.put(kind, map.get(kind) + 1);
                } else {
                    map.put(kind, 1);
                }
            }
            int sum = 1;
            for (int x : map.values()) {
                sum *= (x + 1);
            }

            sb.append(sum - 1).append("\n");
        }

        System.out.println(sb);
    }
}
