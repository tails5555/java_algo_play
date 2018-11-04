package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 14501 번 문제 풀이
public class Main14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for(int k=0;k<N;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[k + 1] = Math.max(dp[k], dp[k + 1]);
            if(k + d <= N) dp[k + d] = Math.max(dp[k + d], dp[k] + c);
        }
        System.out.println(dp[N]);
    }
}
