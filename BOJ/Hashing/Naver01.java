package BOJ.Hashing;

import java.io.*;
import java.util.*;

public class Naver01 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[]{1, 2, 3, 3, 3, 3, 4, 4};

        bw.write(solution(arr).toString());
        bw.flush();

        bw.close();
    }

    static List<Integer> solution(int[] arr) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int val : map.values()) {
            if (val >= 2) {
                list.add(val);
            }
        }

        if (list.isEmpty()) {
            list.add(-1);
        }

        return list;
    }
}
