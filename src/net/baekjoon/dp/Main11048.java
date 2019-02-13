package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 11048 번 문제
public class Main11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        for(int k = 1; k <= N; k++){
            int idx = 1;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens())
                map[k][idx++] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][M + 1];
        for(int n = 1; n <= N; n++){
            for(int m = 1; m <= M; m++){
                dp[n][m] = map[n][m] + Math.max(dp[n - 1][m], dp[n][m - 1]);
            }
        }

        System.out.println(dp[N][M]);
    }
}
