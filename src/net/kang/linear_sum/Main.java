package net.kang.linear_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1912번 연속 합 문제
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] num = new long[N+1];
        long[] dp = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int idx = 1;
        while(st.hasMoreTokens()){
            num[idx++] = Long.parseLong(st.nextToken());
        }
        dp[1] = num[1];
        long max = Long.MIN_VALUE;
        for(int k=1;k<=N;k++){
            dp[k] = Math.max(dp[k - 1] + num[k], num[k]);
            if(max < dp[k]) max = dp[k];
        }
        System.out.println(max);
    }
}
