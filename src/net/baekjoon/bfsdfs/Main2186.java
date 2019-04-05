package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 2186번 문자판 문제 풀이
// 이는 DFS 와 DP 를 사용해서 걸리는 시간을 단축하는 것이 중요하다.
public class Main2186 {
    static BufferedReader br;
    static StringTokenizer st;

    static final int[] dr = { 1, 0, -1,  0 };
    static final int[] dc = { 0, 1,  0, -1 };

    static int N, M, K, res;
    static int[][][] dp;
    static char[][] map;
    static String target;

    static boolean hasInside(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int k = 0; k < N; k++){
            map[k] = br.readLine().toCharArray();
        }

        target = br.readLine();
    }

    static void initialize() {
        dp = new int[N][M][80]; // 단어 수는 80개!
        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                Arrays.fill(dp[n][m], -1);
            }
        }
    }

    static void finding() {
        res = 0;
        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                if(map[n][m] == target.charAt(0)) {
                    res += dfs(n, m, 0);
                }
            }
        }
    }

    static int dfs(int r, int c, int idx){
        if(idx == target.length() - 1) return 1;
        if(dp[r][c][idx] != -1) return dp[r][c][idx];

        dp[r][c][idx] = 0;
        for(int k = 1; k <= K; k++){
            for(int l = 0; l < dr.length; l++){
                int tr = r + dr[l] * k;
                int tc = c + dc[l] * k;
                if(hasInside(tr, tc)) {
                    if(map[tr][tc] == target.charAt(idx + 1)) {
                        dp[r][c][idx] += dfs(tr, tc, idx + 1);
                    }
                }
            }
        }

        return dp[r][c][idx];
    }

    public static void main(String[] args) throws IOException {
        input();
        initialize();
        finding();
        System.out.println(res);
    }
}
