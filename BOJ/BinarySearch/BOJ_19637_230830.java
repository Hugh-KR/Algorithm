package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*
    14:00~14:17(17분)

    *이분탐색*

    10억 * 10억
    - 칭호는 전투력 상한값의 비내림차순
    - 칭호가 없는 전투력은 없음
    - 해당 전투력 이하면 칭호 획득
 */
public class BOJ_19637_230830 {

    static int n,m;
    static ArrayList<Achiev> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String achiev = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            list.add(new Achiev(achiev, score));
        }

        for (int i = 0; i < m; i++) {
            int user = Integer.parseInt(br.readLine());
            sb.append(binarySearch(user)).append("\n");
        }

        System.out.println(sb);
    }

    static String binarySearch(int val) {
        int L = 0;
        int R = list.size()-1;

        while (L <= R) {
            int mid = (L+R) / 2;

            if (val <= list.get(mid).score) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return list.get(L).achiev;
    }

    static class Achiev {
        String achiev;
        int score;

        public Achiev(String achiev, int score) {
            this.achiev = achiev;
            this.score = score;
        }
    }
}
