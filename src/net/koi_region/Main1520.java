package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2006 고등부 지역본선 3번 내리막길 문제 풀이
public class Main1520 {
    static final int[] dr = { 1, 0, -1,  0 };
    static final int[] dc = { 0, 1,  0, -1 };

    static BufferedReader br;
    static StringTokenizer st;
    static int R, C;
    static int[][] map;
    static int[][] dp;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];
        dp = new int[R + 1][C + 1];

        for(int k = 1; k <= R; k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 1; l <= C; l++){
                map[k][l] = Integer.parseInt(st.nextToken());
                dp[k][l] = -1;
            }
        }
    }

    static boolean hasInside(int r, int c){
        return r >= 1 && r <= R && c >= 1 && c <= C;
    }

    static int dfs(int r, int c){
        if(r == 1 && c == 1) return 1;
        if(dp[r][c] < 0) {
            dp[r][c] = 0;
            for (int k = 0; k < 4; k++) {
                int tr = r + dr[k];
                int tc = c + dc[k];
                if (hasInside(tr, tc)) {
                    if (map[tr][tc] > map[r][c])
                        dp[r][c] += dfs(tr, tc);
                }
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dfs(R, C));
    }
}
