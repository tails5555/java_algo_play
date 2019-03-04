package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1309번 동물원 문제 풀이
public class Main1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for(int k = 2; k <= N; k++){
            dp[k][0] = (dp[k - 1][0] + dp[k - 1][1] + dp[k - 1][2]) % 9901;
            dp[k][1] = (dp[k - 1][0] + dp[k - 1][2]) % 9901;
            dp[k][2] = (dp[k - 1][0] + dp[k - 1][1]) % 9901;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
    }
}