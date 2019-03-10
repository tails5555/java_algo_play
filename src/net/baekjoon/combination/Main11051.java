package net.baekjoon.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 11051 번 이항계수 2 문제 풀이
public class Main11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][N + 1];
        dp[1][0] = 1;
        dp[1][1] = 1;

        for(int k = 2; k <= N; k++) {
            for(int l = 0; l <= k; l++){
                if(l == 0 || l == k)
                    dp[k][l] = 1;
                else
                    dp[k][l] = (dp[k - 1][l - 1] + dp[k - 1][l]) % 10007;
            }
        }
        System.out.println(dp[N][R]);
    }
}
