package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1904 번 01 타일 문제 풀이
public class Main1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000000 + 1];

        dp[1] = 1;
        dp[2] = 2;
        for(int k = 3; k <= N; k++){
            dp[k] = (dp[k - 1] + dp[k - 2]) % 15746;
        }

        System.out.println(dp[N]);
    }
}

// N = 1 => (1) 1
// N = 2 => (00) (11) 2
// N = 3 => (100) (001) (111) 3
// N = 4 => (1100) (1001) (0011) (1111) (0000) 5
// N = 5 => (10000) (00001) (11111) (00111) (10011) (11001) (11100) 7