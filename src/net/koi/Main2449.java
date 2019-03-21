package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 2449 번 KOI 2011 초등부 전구 문제 풀이
// 풀이 참조...ㅜㅜ
public class Main2449 {
    static final int INF = 87654321;
    static final int MAX = 201;
    static int[] light;
    static int[][] dp;

    static int func(int s, int f) {
        if(s == f) return 0;
        if(dp[s][f] != -1) return dp[s][f];
        dp[s][f] = INF;
        for(int k = s; k < f; k++){
            int tmp = light[s] != light[f] ? 1 : 0;
            dp[s][f] = Math.min(dp[s][f], func(s, k) + func(k + 1, f) + tmp);
        }
        return dp[s][f];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        dp = new int[MAX][MAX];
        light = new int[N + 1];
        for(int k = 1; k <= N; k++) {
            light[k] = Integer.parseInt(st.nextToken());
        }
        for(int k = 0; k < MAX; k++){
            Arrays.fill(dp[k], -1);
        }
        System.out.println(func(1, N));
    }
}
