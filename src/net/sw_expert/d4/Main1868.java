package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// SW Expert D4 파핑파핑 지뢰찾기 문제 풀이
public class Main1868 {
    static final int MINE = 10;
    static final int[] dr = { 1, 1, 1, 0, -1, -1, -1, 0 };
    static final int[] dc = { 1, 0, -1, -1, -1, 0, 1, 1 };

    static int N;
    static int[][] map;

    static boolean hasInside(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for(int l = 0; l < N; l++){
                char[] tmp = br.readLine().toCharArray();
                for(int m = 0; m < N; m++){
                    if(tmp[m] == '*'){
                        map[l][m] = MINE;
                    }
                }
            }
            for(int l = 0; l < N; l++){
                for(int m = 0; m < N; m++){
                    if(map[l][m] != MINE) {
                        for (int t = 0; t < dr.length; t++) {
                            int tr = l + dr[t];
                            int tc = m + dc[t];
                            if (hasInside(tr, tc)) {
                                if (map[tr][tc] == MINE) {
                                    map[l][m] += 1;
                                }
                            }
                        }
                    }
                }
            }

            int cnt = 0;
            boolean[][] checked = new boolean[N][N];
            for(int l = 0; l < N; l++){
                for(int m = 0; m < N; m++){
                    if(!checked[l][m] && map[l][m] == 0) {
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{l, m});
                        checked[l][m] = true;
                        while (!queue.isEmpty()) {
                            int[] tmp = queue.poll();
                            if(map[tmp[0]][tmp[1]] == 0) {
                                for (int t = 0; t < dr.length; t++) {
                                    int tr = tmp[0] + dr[t];
                                    int tc = tmp[1] + dc[t];
                                    if (hasInside(tr, tc)) {
                                        if (map[tr][tc] != MINE && !checked[tr][tc]) {
                                            checked[tr][tc] = true;
                                            queue.offer(new int[]{tr, tc});
                                        }
                                    }
                                }
                            }
                        }
                        cnt += 1;
                    }
                }
            }

            for(int l = 0; l < N; l++){
                for(int m = 0; m < N; m++){
                    if(map[l][m] >= 1 && map[l][m] <= 8 && !checked[l][m]) cnt += 1;
                }
            }

            System.out.printf("#%d %d\n", k + 1, cnt);
        }
    }
}
