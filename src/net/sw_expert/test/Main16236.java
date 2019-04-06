package net.sw_expert.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 삼성 SW 역량 테스트 기출 문제(아기 상어) 문제 풀이
// BFS 를 더욱 응용할 수 있는 재미있었던 문제. 꼭 풀어보길 추천하고 싶은 문제.
public class Main16236 {
    static BufferedReader br;
    static StringTokenizer st;

    static final int[] dr = { -1,  0, 1, 0 };
    static final int[] dc = {  0, -1, 0, 1 };

    static int N, res;
    static int[][] map;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                map[k][l] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
    }

    static boolean hasInside(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void bfs(int r, int c){
        List<int[]> eating; // 아기 상어의 위치 기억 리스트

        // BFS 에서 꼭 사용되는 친구들
        Queue<int[]> queue;
        boolean[][] visited;

        // 상어의 크기와 포화량
        int baby = 2;
        int ate_cnt = 0;
        while(true) {
            queue = new LinkedList<>();
            eating = new ArrayList<>();
            visited = new boolean[N][N];

            queue.offer(new int[] { r, c, 0 });
            visited[r][c] = true;

            int dist = -1;
            while (!queue.isEmpty()) {
                int[] tmp = queue.poll();

                // 물고기의 탐색이 멈춰지면 그만 BFS 탐색한다.
                if(dist == tmp[2]) break;

                for (int k = 0; k < dr.length; k++) {
                    int tr = tmp[0] + dr[k];
                    int tc = tmp[1] + dc[k];

                    // 범위 안에 움직일 수 있으면 아래에 따른다.
                    if (hasInside(tr, tc)) {
                        // 아기 상어보다 덩치가 크지 않은 물고기들이 있으면 방문 처리한다.
                        if (!visited[tr][tc] && map[tr][tc] <= baby) {
                            visited[tr][tc] = true;

                            // 물고기의 크기가 아기 상어보다 작으면 아기 상어는 위치만 기억한다.
                            if (map[tr][tc] < baby && map[tr][tc] > 0) {
                                dist = tmp[2] + 1;
                                eating.add(new int[]{ tr, tc, tmp[2] + 1 });
                            }

                            // 다음 이동 거리를 BFS 로 탐색.
                            queue.offer(new int[]{ tr, tc, tmp[2] + 1 });
                        }
                    }
                }
            }

            if(dist != -1) {
                if(eating.size() > 1) {
                    // 1순위. 맨 위에 있는 물고기, 2순위. 왼쪽에 있는 물고기, 3순위. 걍 아무거나.
                    Collections.sort(eating, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
                }

                // 이에 해당되는 물고기를 가져온다.
                int[] first = eating.get(0);

                // 시간 누적
                res += dist;

                // 상어의 위치 재조정
                map[r][c] = 0;
                r = first[0];
                c = first[1];
                map[first[0]][first[1]] = 9;

                // 아기 상어의 포화양 측정
                ate_cnt += 1;
                if(ate_cnt == baby) {
                    baby += 1;
                    ate_cnt = 0;
                }
            } else break;
        }
    }

    static void finding() {
        for(int k = 0; k < N; k++){
            for(int l = 0; l < N; l++){
                if(map[k][l] == 9) {
                    map[k][l] = 0;
                    bfs(k, l);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        finding();
        System.out.println(res);
    }
}
