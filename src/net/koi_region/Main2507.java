package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon KOI 2008 중등부 지역본선 4번 공주 구하기 문제 풀이
public class Main2507 {
    static BufferedReader br;
    static StringTokenizer st;

    static int[] pos, power;
    static boolean[] with;

    static int[][] a, dp;
    static int N;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pos = new int[N];
        power = new int[N];
        with = new boolean[N];

        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");

            pos[k] = Integer.parseInt(st.nextToken());
            power[k] = Integer.parseInt(st.nextToken());
            with[k] = st.nextToken().equals("1");
        }

        a = new int[N][N];
        dp = new int[N][N];
    }

    static void initialize() {
        for(int k = 0; k < N; k++){
            for(int l = 0; l < N; l++){
                if(Math.abs(pos[k] - pos[l]) <= power[k] && !(k > l && !with[k]))
                    a[k][l] = 1;
            }
        }

        for(int k = 0; k < N; k++){
            Arrays.fill(dp[k], -1);
        }
    }

    static int backtracking(int x, int y){
        if(dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        if(x != N - 1 && y != N - 1){
            if(a[N - 1][x] > 0 && a[y][N - 1] > 0) dp[x][y] = 1;
        }
        for(int k = Math.max(x, y) + 1; k < N; k++){
            if(a[k][x] > 0)
                dp[x][y] += backtracking(k, y);
            dp[x][y] %= 1000;
            if(a[y][k] > 0)
                dp[x][y] += backtracking(x, k);
            dp[x][y] %= 1000;
        }

        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        input();
        initialize();
        System.out.println(backtracking(0, 0));
    }
}
