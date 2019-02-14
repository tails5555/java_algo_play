package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 2410 번 문제 풀이
public class Main2410 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[1 + N];
        dp[0] = 1;
        for(int k = 1; k <= N; k++){
            dp[k] = (dp[k - 1] + (k % 2 == 0 && dp[k / 2] > 0 ? dp[k / 2] : 0)) % 1000000000;
        }
        System.out.println(dp[N]);
    }
}

/*
 * 1 => 1
 * 2 => 1 + 1, 2 => 2
 * 3 => 1 + (2) => 1 + 1 + 1, 1 + 2 => 2
 * 4 => 1 + (3), 2 + 2, 4 + 0
 * 5 => 1 + (4), 2 + (3), 4 + 1
 * 6 => 1 + (5), 2 + (4), 4 + (2)
 * 7 => 1 + (6), 2 + (5), 4 + (3)
 */