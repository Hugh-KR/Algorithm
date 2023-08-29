package CT.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    14:27~16:00

    *구현*

    - 각 도형 네모로 감싸서 크기 비교하기
    - 3개로 소분류 해서 구할 수 있다
 */
public class SPS_03_230815 {
    static int[][] map;
    static int[] arr1;
    static int[][] arr2;
    static int[][] arr3;
    static int[][] arr4;
    static int[][] arr5;
    static int max = Integer.MIN_VALUE;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) { // 배열 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 도형 만들고 연산 수행
        Figure_1();
        Figure_2();
        Figure_3();
        Figure_4();
        Figure_5();

        System.out.println(max);

    }

    static void Figure_1() {
        arr1 = new int[5];
        int[][] arr1_2 = new int[5][2];

        for (int i = 1; i <= 4; i++) {
            arr1[i] = 1;
        }

        for (int i = 1; i <= 4; i++) {
            arr1_2[i][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m-3; j++) {
                int arr3Sum = 0;
                for (int a = j; a < (arr1.length-1)+j; a++) {
                    if (arr1[a-j+1] == 1) {
                        arr3Sum += map[i][a];
                    }
                }

                max = Math.max(max, arr3Sum);

            }
        }

        for (int i = 1; i <= n-3; i++) {
            for (int j = 1; j <= m; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr1_2.length-1)+i; a++) {
                    if (arr1_2[a-i+1][1] == 1) {
                        arr3Sum += map[a][j];
                    }
                }

                max = Math.max(max, arr3Sum);

            }
        }
    }
    static void Figure_2() {
        arr2 = new int[3][3];
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                arr2[i][j] = 1;
            }
        }

        for (int i = 1; i <= n-1; i++) {
            for (int j = 1; j <= m-1; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr2.length-1)+i; a++) {
                    for (int b = j; b < (arr2.length-1)+j; b++) {
                        if (arr2[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }

                max = Math.max(max, arr3Sum);

            }
        }
    }
    static void Figure_3() {
        arr3 = new int[4][3];
        int[][] arr3_2 = new int[4][3];
        int[][] arr3_3 = new int[4][3];
        int[][] arr3_4 = new int[4][3];

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 2; j++) {
                arr3[i][j] = 1;
                arr3_2[i][j] = 1;
                arr3_3[i][j] = 1;
                arr3_4[i][j] = 1;
            }
        }
        // 잘라내서 모양 맞추기
        arr3[1][2] = 0;
        arr3[2][2] = 0;

        arr3_2[2][2] = 0;
        arr3_2[3][2] = 0;

        arr3_3[2][1] = 0;
        arr3_3[3][1] = 0;

        arr3_4[1][1] = 0;
        arr3_4[2][1] = 0;

        for (int i = 1; i <= n-2; i++) {
            for (int j = 1; j <= m-1; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr3.length-1)+i; a++) {
                    for (int b = j; b < (arr3[0].length-1)+j; b++) {
                        if (arr3[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }
                max = Math.max(max, arr3Sum);
            }

            for (int j = 1; j <= m-1; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr3_2.length-1)+i; a++) {
                    for (int b = j; b < (arr3_2[0].length-1)+j; b++) {
                        if (arr3_2[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }
                max = Math.max(max, arr3Sum);
            }

            for (int j = 1; j <= m-1; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr3_3.length-1)+i; a++) {
                    for (int b = j; b < (arr3_3[0].length-1)+j; b++) {
                        if (arr3_3[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }
                max = Math.max(max, arr3Sum);
            }

            for (int j = 1; j <= m-1; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr3_4.length-1)+i; a++) {
                    for (int b = j; b < (arr3_4[0].length-1)+j; b++) {
                        if (arr3_4[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }
                max = Math.max(max, arr3Sum);
            }
        }

        int[][] arr3_5 = new int[3][4];
        int[][] arr3_6 = new int[3][4];
        int[][] arr3_7 = new int[3][4];
        int[][] arr3_8 = new int[3][4];

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 3; j++) {
                arr3_5[i][j] = 1;
                arr3_6[i][j] = 1;
                arr3_7[i][j] = 1;
                arr3_8[i][j] = 1;
            }
        }

        arr3_5[2][2] = 0;
        arr3_5[2][3] = 0;

        arr3_6[1][2] = 0;
        arr3_6[1][3] = 0;

        arr3_7[1][1] = 0;
        arr3_7[1][2] = 0;

        arr3_8[2][1] = 0;
        arr3_8[2][2] = 0;

        for (int i = 1; i <= n-1; i++) {
            for (int j = 1; j <= m-2; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr3_5.length - 1) + i; a++) {
                    for (int b = j; b < (arr3_5[0].length - 1) + j; b++) {
                        if (arr3_5[a - i + 1][b - j + 1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }
                max = Math.max(max, arr3Sum);
            }

            for (int j = 1; j <= m-2; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr3_6.length - 1) + i; a++) {
                    for (int b = j; b < (arr3_6[0].length - 1) + j; b++) {
                        if (arr3_6[a - i + 1][b - j + 1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }
                max = Math.max(max, arr3Sum);
            }

            for (int j = 1; j <= m-2; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr3_7.length - 1) + i; a++) {
                    for (int b = j; b < (arr3_7[0].length - 1) + j; b++) {
                        if (arr3_7[a - i + 1][b - j + 1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }
                max = Math.max(max, arr3Sum);
            }

            for (int j = 1; j <= m-2; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr3_8.length - 1) + i; a++) {
                    for (int b = j; b < (arr3_8[0].length - 1) + j; b++) {
                        if (arr3_8[a - i + 1][b - j + 1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }
                max = Math.max(max, arr3Sum);
            }
        }
    }
    static void Figure_4() {
        arr4 = new int[4][3];
        int[][] arr4_2 = new int[4][3];
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 2; j++) {
                arr4[i][j] = 1;
                arr4_2[i][j] = 1;
            }
        }
        // 잘라내서 모양 맞추기
        arr4[1][2] = 0;
        arr4[3][1] = 0;

        arr4_2[1][1] = 0;
        arr4_2[3][2] = 0;

        for (int i = 1; i <= n-2; i++) {
            for (int j = 1; j <= m-1; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr4.length-1)+i; a++) {
                    for (int b = j; b < (arr4[0].length-1)+j; b++) {
                        if (arr4[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }

                max = Math.max(max, arr3Sum);

            }

            for (int j = 1; j <= m-1; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr4_2.length-1)+i; a++) {
                    for (int b = j; b < (arr4_2[0].length-1)+j; b++) {
                        if (arr4_2[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }

                max = Math.max(max, arr3Sum);

            }
        }

        int[][] arr4_3 = new int[3][4];
        int[][] arr4_4 = new int[3][4];
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 3; j++) {
                arr4_3[i][j] = 1;
                arr4_4[i][j] = 1;
            }
        }

        // 잘라내서 모양 맞추기
        arr4_3[1][1] = 0;
        arr4_3[2][3] = 0;

        arr4_4[2][1] = 0;
        arr4_4[1][3] = 0;

        for (int i = 1; i <= n-1; i++) {
            for (int j = 1; j <= m-2; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr4_3.length-1)+i; a++) {
                    for (int b = j; b < (arr4_3[0].length-1)+j; b++) {
                        if (arr4_3[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }

                max = Math.max(max, arr3Sum);

            }

            for (int j = 1; j <= m-2; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr4_4.length-1)+i; a++) {
                    for (int b = j; b < (arr4_4[0].length-1)+j; b++) {
                        if (arr4_4[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }
                max = Math.max(max, arr3Sum);

            }
        }
    }
    static void Figure_5() {
        arr5 = new int[4][3];
        int[][] arr5_2 = new int[4][3];
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 2; j++) {
                arr5[i][j] = 1;
                arr5_2[i][j] = 1;
            }
        }
        // 잘라내서 모양 맞추기
        arr5[1][2] = 0;
        arr5[3][2] = 0;

        // 잘라내서 모양 맞추기
        arr5_2[1][1] = 0;
        arr5_2[3][1] = 0;

        for (int i = 1; i <= n-2; i++) {
            for (int j = 1; j <= m-1; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr5.length-1)+i; a++) {
                    for (int b = j; b < (arr5[0].length-1)+j; b++) {
                        if (arr5[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }

                max = Math.max(max, arr3Sum);

            }

            for (int j = 1; j <= m-1; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr5_2.length-1)+i; a++) {
                    for (int b = j; b < (arr5_2[0].length-1)+j; b++) {
                        if (arr5_2[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }

                max = Math.max(max, arr3Sum);

            }
        }

        int[][] arr5_3 = new int[3][4];
        int[][] arr5_4 = new int[3][4];
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 3; j++) {
                arr5_3[i][j] = 1;
                arr5_4[i][j] = 1;
            }
        }
        // 잘라내서 모양 맞추기
        arr5_3[1][1] = 0;
        arr5_3[1][3] = 0;

        // 잘라내서 모양 맞추기
        arr5_4[2][1] = 0;
        arr5_4[2][3] = 0;


        for (int i = 1; i <= n-1; i++) {
            for (int j = 1; j <= m-2; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr5_3.length-1)+i; a++) {
                    for (int b = j; b < (arr5_3[0].length-1)+j; b++) {
                        if (arr5_3[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }

                max = Math.max(max, arr3Sum);

            }

            for (int j = 1; j <= m-2; j++) {
                int arr3Sum = 0;
                for (int a = i; a < (arr5_4.length-1)+i; a++) {
                    for (int b = j; b < (arr5_4[0].length-1)+j; b++) {
                        if (arr5_4[a-i+1][b-j+1] == 1) {
                            arr3Sum += map[a][b];
                        }
                    }
                }

                max = Math.max(max, arr3Sum);

            }
        }
    }

}
