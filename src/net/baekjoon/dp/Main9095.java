package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 9095번 문제 풀이
public class Main9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int k=0;k<T;k++){
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[11];
            dp[0] = 1;
            for(int l=1;l<=N;l++){
                if(l - 1 >= 0) dp[l] += dp[l - 1];
                if(l - 2 >= 0) dp[l] += dp[l - 2];
                if(l - 3 >= 0) dp[l] += dp[l - 3];
            }
            System.out.println(dp[N]);
        }
    }
}
