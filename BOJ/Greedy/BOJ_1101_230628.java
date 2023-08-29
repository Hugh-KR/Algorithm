package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 박스 최대 1개 조커 박스
 * 2. 나머지는 비어 있거나 같은색의 카드
 * 3. 같은 색을 가진 모든 카드 같은 박스 (조커 박스 제외)
 *
 * 규칙을 찾아라?
 *
 */
public class BOJ_1101_230628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[50][50];
        int[] cnt = new int[50];
        boolean[] visited = new boolean[50];

        // 2개 이상 색을 가진 상자를 찾기위한 cnt
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) cnt[i]++;
            }
        }

        int ans = n;
        for (int i = 0; i < n; i++) {
            int rev = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (cnt[j] > 1) rev++;
                else if (cnt[j] == 0) continue;
                else {
                    boolean flag = false;
                    for (int k = 0; k < m; k++) {
                        if (arr[j][k] != 0 && !visited[k]) {
                            visited[k] = true;
                            flag = !flag;
                            break;
                        }
                    }
                    if (!flag) rev++;
                }
            }
            ans = Math.min(ans, rev);
        }

        sb.append(ans);
        System.out.println(sb);
    }
}
