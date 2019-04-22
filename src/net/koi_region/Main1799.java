package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2007 지역본선 초등부 5번 비숍 문제 풀이
public class Main1799 {
    static final int[] dr = { -1,  1, -1, 1 };
    static final int[] dc = { -1, -1,  1, 1 };

    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static boolean[][] map;
    static int[][] colors;
    static boolean[] visited;
    static int[] ans;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        colors = new int[N][N];
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                map[k][l] = st.nextToken().equals("1") ? true : false;
                if(k % 2 == 0){
                    if(l % 2 == 0){
                        colors[k][l] = 1;
                    }
                } else {
                    if(l % 2 != 0) {
                        colors[k][l] = 1;
                    }
                }
            }
        }
    }

    static void initialize() {
        visited = new boolean[N * N];
        ans = new int[2];
    }

    static void backtracking(int v, int cnt, int color) {
        if(cnt > ans[color]){
            ans[color] = cnt;
        }
        for(int k = v + 1; k < N * N; k++){
            int row = k / N;
            int col = k % N;
            if(colors[row][col] != color) continue;
            if(map[row][col]){
                if(checked(row, col)){
                    visited[k] = true;
                    backtracking(k, cnt + 1, color);
                }
            }
        }

        if(v == -1) return;
        visited[v] = false;
    }

    static boolean checked(int row, int col){
        for(int k = 0; k < 4; k++){
            int tr = row + dr[k];
            int tc = col + dc[k];
            int v = tr * N + tc;
            for(int l = 1; l < N; l++){
                if(tr >= 0 && tr < N && tc >= 0 && tc < N) {
                    if (visited[v]) return false;
                    tr += dr[k];
                    tc += dc[k];
                    v = tr * N + tc;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        initialize();
        backtracking(-1, 0, 0);
        backtracking(-1, 0, 1);
        System.out.println(ans[0] + ans[1]);
    }
}
