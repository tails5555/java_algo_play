package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 2225번 문제 풀이
public class Main2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[K + 1][N + 1];
        Arrays.fill(dp[1], 1);
        for(int k = 1; k <= K; k++) {
            for (int l = 0; l <= N; l++) {
                for(int m = 0; m <= l; m++) {
                    dp[k][l] = (dp[k][l] + dp[k - 1][l - m]) % 1000000000;
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}

// 5 2 의 케이스
// 5 + 1 = 6

// 5 3 의 케이스
/*
 * 0 0 5
 * 0 1 4
 * 0 2 3
 * 0 3 2
 * 0 4 1
 * 0 5 0
 * 0 (5 2) => 6
 *
 * 1 0 4
 * 1 1 3
 * 1 2 2
 * 1 3 1
 * 1 4 0
 * 1 (4 2) => 5
 *
 * ...
 *
 * 5 0 0 => 1
 *
 * 0 (5 2) + 1 (4 2) + ... + 5 (0 0)
 */

// 5 4 의 케이스
// 0 (5 3) + 1 (4 3) + ... + 5 (0 0)
