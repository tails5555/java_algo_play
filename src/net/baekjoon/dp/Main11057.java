package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Baekjoon 11057 번 문제 풀이
public class Main11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10];
        Arrays.fill(dp[1], 1);
        for(int k=2;k<=N;k++){
            for(int l=0;l<=9;l++){
                for(int m=0;m<=l;m++) {
                    dp[k][l] += dp[k - 1][m];
                }
                dp[k][l] %= 10009;
            }
        }

        long sum = 0;
        for(int k=0;k<=9;k++){
            sum = (sum + dp[N][k]);
        }
        System.out.println(sum % 10009);
    }
}

/*
 * N = 1
 * 0 ~ 9 => 10
 * N = 2
 * 0 ~ 9 => 10
 * 11 ~ 19 => 9
 * 22 ~ 29 => 8
 * ...
 * 99 => 1
 * 총합 55
 *
 * N = 3
 * 0 ~ 99 = 55
 * 100 ~ 199 = 1 + 11~19, 22~29 ... 99
 * 200 ~ 299 = 2 + 22 ~ 29 ... 99
 * ...
 * 900 ~ 999 = 999
 */