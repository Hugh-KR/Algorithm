package BOJ.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    13:14~14:07

    *정수론*

    중간에 정수 추가해서 인접한 공약수 1만들기
    중간에는 하나 혹은 두개의 수가 들어갈 수 있다 (하나로 처리할 수 없는 경우 둘이라면 처리 가능)

    두 수 사이 완전탐색 해서 하나로 가능한지 찾기

    기본적으로 정렬이 필요함
 */
public class BOJ_14252_230809 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 정렬하고 진행

        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (gcd(arr[i], arr[i + 1]) == 1) continue;

            if (OneGCD(i)) cnt++; // 통과 했다면 하나만 끼워 넣음
            else cnt+=2; // 통과하지 못했다면 두개 끼워 넣음
        }

        System.out.println(cnt);
    }


    static boolean OneGCD(int idx) { // 완전탐색 돌며 하나만 끼워넣으면 만족하는지 확인
        for (int j = arr[idx]+1; j < arr[idx + 1]; j++) {
            if (gcd(arr[idx], j) == 1 && gcd(arr[idx + 1], j) == 1) {
                return true;
            }
        }
        return false;
    }

    static int gcd(int a, int b) { // gcd 구하는 알고리즘
        while (b % a != 0) {
            int tmp = b % a;
            b = a;
            a = tmp;
        }
        return a;
    }
}
