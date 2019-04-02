package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 2573 빙산 문제 풀이
public class Main2573 {
    static BufferedReader br;
    static StringTokenizer st;
    static int R, C;
    static int[][] map;
    static final int[] dr = { -1, 1,  0, 0 };
    static final int[] dc = {  0, 0, -1, 1 };

    static boolean hasInside(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int k = 0; k < R; k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < C; l++){
                map[k][l] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs() {
        int year = 0;
        while(true){
            boolean all_melt = true;
            for(int k = 0; k < R; k++){
                for(int l = 0; l < C; l++){
                    if(map[k][l] > 0) {
                        all_melt = false;
                        break;
                    }
                }
            }

            if(all_melt) {
                year = 0;
                break;
            }

            Queue<int[]> queue = new LinkedList<>();
            List<int[]> changed = new ArrayList<>();
            boolean[][] visited = new boolean[R][C];

            int melt_cnt = 0;
            for(int k = 0; k < R; k++){
                for(int l = 0; l < C; l++){
                    if(!visited[k][l] && map[k][l] > 0) {
                        queue.offer(new int[] { k, l });
                        visited[k][l] = true;
                        while(!queue.isEmpty()){
                            int[] tmp = queue.poll();
                            int cnt = 0;
                            for(int m = 0; m < dr.length; m++){
                                int tr = tmp[0] + dr[m];
                                int tc = tmp[1] + dc[m];
                                if(hasInside(tr, tc)){
                                    if(map[tr][tc] == 0) {
                                        cnt += 1;
                                    } else if(!visited[tr][tc] && map[tr][tc] > 0) {
                                        queue.offer(new int[] { tr, tc });
                                        visited[tr][tc] = true;
                                    }
                                }
                            }
                            changed.add(new int[] { tmp[0], tmp[1], cnt });
                        }

                        melt_cnt += 1;
                    }
                }
            }

            if(melt_cnt > 1) break;
            else {
                year += 1;
                for(int[] d : changed){
                    int cnt = Math.max(0, map[d[0]][d[1]] - d[2]);
                    map[d[0]][d[1]] = cnt;
                }
            }
        }

        System.out.println(year);
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
    }
}
