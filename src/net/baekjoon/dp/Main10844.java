package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Baekjoon 10844 번 문제 풀이
public class Main10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][11];
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;
        dp[1][10] = 0;
        for(int k=2;k<=N;k++){
            dp[k][0] = dp[k - 1][1];
            for(int l=1;l<=9;l++){
                dp[k][l] = (dp[k - 1][l + 1] + dp[k - 1][l - 1]) % 1000000000;
            }
        }

        long sum = 0;
        for(int k=0;k<=9;k++){
            sum += dp[N][k];
        }
        System.out.println(sum % 1000000000);
    }
}

/*
 * N = 1
 * 1, 2, 3, 4, 5, 6, 7, 8, 9
 *
 * N = 2
 * 10 12 21 23 32 34 43 45 54 56 65 67 76 78 87 89 98
 *
 * DP(N, K) => K 의 값은 0 ~ 9 이다.
 * K == 0 => 1의 값만. K == 9 => 8의 값만.
 * DP(2, 1) = DP(1, 0) + DP(1, 2)
 *
 * DP(N, 0) => DP(N - 1, 1)
 * DP(N, K) => DP(N - 1, K - 1) + DP(N - 1, K + 1) (K >= 1 && K <= 8)
 * DP(N, 9) => DP(N - 1, 8)
 */