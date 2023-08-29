package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_9280_230512 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int[] Ri = new int[n];
            for (int i = 0; i < n; i++)
                Ri[i] = Integer.parseInt(br.readLine());
            int[] Wi = new int[m];
            for (int i = 0; i < m; i++)
                Wi[i] = Integer.parseInt(br.readLine());

            int[] parkingLot = new int[n];
            Queue<Integer> waiting = new LinkedList<>();
            int income = 0;
            for (int i = 0; i < 2 * m; i++) {
                int car = Integer.parseInt(br.readLine());
                // 들어올 경우
                if (car > 0) {
                    car -= 1;
                    if (isFull(parkingLot))
                        waiting.offer(car);
                    else {
                        for (int j = 0; j < n; j++) {
                            if (parkingLot[j] == 0) {
                                parkingLot[j] = Wi[car];
                                break;
                            }
                        }
                    }
                }
                // 나갈 경우
                else if (car < 0) {
                    car = Math.abs(car) - 1;
                    for (int j = 0; j < n; j++) {
                        if (parkingLot[j] == Wi[car]) {
                            income += (parkingLot[j] * Ri[j]);
                            if (!waiting.isEmpty())
                                parkingLot[j] = Wi[waiting.poll()];
                            else
                                parkingLot[j] = 0;
                            break;
                        }
                    }
                }
            }
            sb.append(String.format("#%d %d\n", t, income));
        }
        System.out.println(sb);
        br.close();
    }

    private static boolean isFull(int[] parkingLot) {
        for (int i = 0; i < parkingLot.length; i++)
            if (parkingLot[i] == 0)
                return false;
        return true;
    }
}
