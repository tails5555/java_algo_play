package net.sw_expert.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 삼성 SW 역량 테스트 기출 문제(인구 이동)
public class Main16234 {
    static int N, L, R, ans;
    static final int[] dr = { -1, 1, 0, 0 };
    static final int[] dc = { 0, 0, -1, 1 };
    static int[][] nation;
    static BufferedReader br;
    static StringTokenizer st;

    static boolean hasInside(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");;

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        nation = new int[N][N];
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                nation[k][l] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs_search() {
        Queue<int[]> queue;
        boolean[][] visited;
        boolean continued = true;
        List<int[]> unions;
        ans = 0;

        while(continued) {
            queue = new LinkedList<>();
            visited = new boolean[N][N];
            continued = false;
            ans += 1;
            for(int k = 0; k < N; k++){
                for(int l = 0; l < N; l++){
                    if(!visited[k][l]) {
                        unions = new ArrayList<>();
                        int uni_cnt = 1; // 실화인지 모르겠지만, List 의 size() 메소드 Time Cmpx 가 O(n) 이다.

                        queue.offer(new int[] { k, l });
                        visited[k][l] = true;
                        unions.add(new int[] { k, l });

                        int total = nation[k][l];
                        while(!queue.isEmpty()) {
                            int[] tmp = queue.poll();
                            for(int m = 0; m < dr.length; m++){
                                int tr = tmp[0] + dr[m];
                                int tc = tmp[1] + dc[m];
                                if(hasInside(tr, tc)) {
                                    if(!visited[tr][tc]) {
                                        int diff = Math.abs(nation[tr][tc] - nation[tmp[0]][tmp[1]]);
                                        if(diff >= L && diff <= R) {
                                            queue.offer(new int[]{tr, tc});
                                            visited[tr][tc] = true;
                                            unions.add(new int[]{tr, tc});
                                            total += nation[tr][tc];
                                            uni_cnt += 1;
                                            continued = true;
                                        }
                                    }
                                }
                            }
                        }

                        if(uni_cnt > 1) {
                            int avg = total / uni_cnt;
                            for (int[] pos : unions) {
                                nation[pos[0]][pos[1]] = avg;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs_search();
        System.out.println(ans - 1);
    }
}
