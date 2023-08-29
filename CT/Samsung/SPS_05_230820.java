package CT.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    09:12~

    *구현*

    - 격자판은 '흰.빨.파' 중 하나의 색을 가짐
    - 1번부터 k번, 상.하.좌.우 이동가능
    - 턴 한 번 동안 1번 말부터 k번 말까지 규칙대로 순서대로 움직임
    - 이미 말이 올려진 곳에도 중복 가능
    - 빨간 칸의 경우 해당칸 이동전 순서 뒤집음
    - 파란칸의 경우 반대로 이동, 격자판 범위 벗어나는 이동도 마찬가지
    - 겹쳐진 말 이동할때 본인 위의 말과 함께 이동
    - 1.2.3.4 (오.왼.상.하)

    게임이 진행되는 동안 한 턴이 끝나지 않은 경우라도 말이 4개 이상 겹쳐지는 경우가 생기면 즉시 게임 종료
    초기에 4개 이상 겹쳐진 입력은 주어지지 않음
    같은 칸에 2개의 말이 입력으로 주어지는 경우 x

    게임이 종료되는 순간의 턴의 번호 구하는 프로그램 설계

    1번 말 부터 차례로 주어짐
    답이 1000보다 크거나 불가능한 경우 -1 출력

    이차원 리스트 만들어 진행
 */
public class SPS_05_230820 {
    static int n,k;
    static int[][] map; // 격자판 조건 설정
    static ArrayList<ArrayList<Integer>> mapList; // 유닛들 담아서 관리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 윳놓이 판의 크기
        k = Integer.parseInt(st.nextToken()); // 말의 개수

        map = new int[n+1][n+1];
        mapList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                mapList.add(new ArrayList<>());
//                mapList.get(j-1).add(new Unit(i,j,0,))
                int state = Integer.parseInt(st.nextToken()); // 흰.빨.파
                map[i][j] = state;
            }
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }

        int unitSum = 0;
        ArrayList<Unit> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[x][y] = i;
            unitSum += i;
            list.add(new Unit(x,y,d,i));
        }

        while (true) { // 4개 겹칠때 까지 반복
            int cnt = 0;

            for (int i = 0; i < k; i++) {
                Unit unit = list.get(i);
                int x = unit.x;
                int y = unit.y;
                int d = unit.d;
                int num = unit.num;

                if (d == 1) y+=1; // 오
                else if (d == 2) y-=1; // 왼
                else if (d == 3) x-=1; // 상
                else if (d == 4) x+=1; // 하

                // 겹쳐진 친구들 같이 이동
                if (map[x][y] == 0) { // 흰색 판
                    boolean flag_0 = false;
                    for (int a = 0; a < mapList.get((unit.x * unit.y)-1).size(); a++) {
                        if (mapList.get((unit.x * unit.y)-1).get(a) == num) flag_0 = true;
                        if (flag_0) {
                            mapList.get((unit.x * unit.y)-1).remove(num);
                            mapList.get((x*y)-1).add(num);
                        }
                    }
                }
                else if (map[x][y] == 1) { // 빨간색 판
                    boolean flag_0 = false;
                    for (int a = 0; a < mapList.get((unit.x * unit.y)-1).size(); a++) {
                        if (mapList.get((unit.x * unit.y)-1).get(a) == num) flag_0 = true;
                        if (flag_0) {
                            mapList.get((unit.x * unit.y)-1).remove(num);
                            mapList.get((x*y)-1).add(0,num);
                        }
                    }
                }
                else if (!isRange(x,y) || map[x][y] == 2) { // 범위 벗어나거나 파란색 판
                    int blueX = unit.x - (unit.x - x);
                    int blueY = unit.y - (unit.y - y);
                    if (!isRange(blueX,blueY) || map[blueX][blueY] == 2) {
                        if (d == 1) unit.d = 2; // 오
                        else if (d == 2) unit.d = 1; // 왼
                        else if (d == 3) unit.d = 4; // 상
                        else if (d == 4) unit.d = 3; // 하
                        continue;
                    }

                    boolean flag_0 = false;
                    for (int a = 0; a < mapList.get((unit.x * unit.y)-1).size(); a++) {
                        if (mapList.get((unit.x * unit.y)-1).get(a) == num) flag_0 = true;
                        if (flag_0) {
                            mapList.get((unit.x * unit.y)-1).remove(mapList.get(a));
                            mapList.get((x*y)-1).add(0, mapList.get((unit.x * unit.y)-1).get(a));
                        }
                    }

                    if (d == 1) unit.d = 2; // 오
                    else if (d == 2) unit.d = 1; // 왼
                    else if (d == 3) unit.d = 4; // 상
                    else if (d == 4) unit.d = 3; // 하


                }
            }

        }
    }

    static boolean isRange(int x, int y) {
        return (x > 0 && y > 0 && x <= n && y <= n);
    }

    static class Unit {
        int x,y,d;
        int num;

        public Unit(int x, int y, int d, int num) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.num = num;
        }
    }
}
