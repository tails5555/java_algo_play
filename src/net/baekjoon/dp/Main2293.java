package net.baekjoon.dp;

import java.util.Scanner;

// 백준 2293번 문제 풀이
public class Main2293 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        int[] dp = new int[10001];
        int[] coins = new int[N];
        for(int k=0;k<N;k++){
            coins[k] = s.nextInt();
        }
        dp[0] = 1;
        for(int k = 0; k < N; k++) {
            for(int l = 1; l <= K; l++) {
                if(l - coins[k] >= 0) dp[l] += dp[l - coins[k]];
            }
        }
        System.out.println(dp[K]);
    }
}
