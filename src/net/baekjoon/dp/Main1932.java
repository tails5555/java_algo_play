package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1932번 문제 풀이
public class Main1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][N+1];
        int max = Integer.MIN_VALUE;
        for(int k=1;k<=N;k++){
            int idx = 1;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int l=1;l<=k;l++) {
                dp[k][idx++] = Integer.parseInt(st.nextToken());
                if(l==1)  dp[k][l] = dp[k-1][l] + dp[k][l];
                else if(l==k) dp[k][l] = dp[k-1][l-1] + dp[k][l];
                else dp[k][l] = Math.max(dp[k-1][l], dp[k-1][l-1]) + dp[k][l];
                if(max < dp[k][l]) max = dp[k][l];
            }
        }
        System.out.println(max);
    }
}
