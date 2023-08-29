package Programmers.Lv3;
import java.util.*;

/*
    09:05~10:06

    * DP *

    맨 아래까지 더한 후 아래에서 max값 반환
    - 왼쪽만 선택했을때와 오른쪽만 선택했을때?
    - 깊은 복사한 배열 통해서 큰값 갱신하며 진행

    1차 시도 실패
    2차 시도 100
*/
public class PG_43105_230804 {
    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] arr = new int[triangle.length][];
        for (int idx = 0; idx < triangle.length; idx++) {
            arr[idx] = triangle[idx].clone();
        }


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i+1][j] = Math.max(arr[i+1][j], triangle[i+1][j] + arr[i][j]);
                arr[i+1][j+1] = Math.max(arr[i+1][j+1], triangle[i+1][j+1] + arr[i][j]);
            }

            // // 출력 해보기
            // for (int z = 0; z < arr.length; z++) {
            //     for (int x = 0; x < arr[z].length; x++) {
            //         System.out.print(arr[z][x] + " ");
            //     }
            //     System.out.println();
            // }

            // 최대값 구하기
            for (int z = 0; z < arr[arr.length-1].length; z++) {
                max = Math.max(max, arr[arr.length-1][z]);
            }

            // // 2차원 깊은 복사
            // for (int idx = 0; idx < triangle.length; idx++) {
            //     arr[idx] = triangle[idx].clone();
            // }
        }

        // for (int i = 0; i < triangle.length; i++) {
        //     for (int j = 0; j < triangle[i].length; j++) {
        //         System.out.println(triangle[i][j]);
        //     }
        // }

        return max;
    }
}
