package CT.Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
    23:02~24:35

    *DFS*

    - 깊이우선탐색으로 병원 찾아서 위치 비교하고 백트레킹으로 최소값 갱신
    - m 개의 병원을 고르는게 불가능한 입력은 주어지지 않는다고 생각해도 좋다.
    - m 개의 병원을 두고 가장 거리가 짧은 경우 구하기
 */
public class SPS_04_230815 {
    static int n,m;
    static int minDist = Integer.MAX_VALUE;
    static boolean[] visited;
    static ArrayList<Position> person = new ArrayList<>();
    static ArrayList<Position> hospital = new ArrayList<>();
    static ArrayList<Position> pickedHosp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];


        for (int i = 1; i <= n; i++) { // 배열 초기값 세팅
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) person.add(new Position(i,j));
                if (map[i][j] == 2) hospital.add(new Position(i,j));
            }
        }
        visited = new boolean[hospital.size()];

        dfs(0,0);
        System.out.println(minDist);
    }

    // 백트래킹 통해 모든 경우의 수 구하기
    static void dfs (int depth, int start) {
        if (depth >= m) {
            minDist = Math.min(minDist, simulation()); // 깊이 m이상 이라면 사람과 병원거리의 최솟값 구하기
            return;
        }

        for (int i = start; i < hospital.size(); i++) {
            if (visited[i]) continue; // 이미 방문한 병원이면 넘기기

            visited[i] = true;
            pickedHosp.add(hospital.get(i)); // 방문하지 않았다면 m개 만큼 픽해줌
            dfs(depth+1, i+1); // DFS 재귀
            pickedHosp.remove(pickedHosp.size()-1); // 끝나면 맨 뒤 병원 풀어주기(다시 참조할 수 있도록)
            visited[i] = false;
        }
    }

    // m만큼 픽한 병원과 사람의 최소 거리 구하기
    static int simulation() {
        int sumDist = 0;

        for (int i = 0; i < person.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                min = Math.min(min, getDist(person.get(i), pickedHosp.get(j)));
            }
            sumDist += min;
        }
        return sumDist;
    }

    static int getDist(Position pers, Position hosp) {
        return (Math.abs(pers.x - hosp.x) + Math.abs(pers.y - hosp.y));
    }

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
