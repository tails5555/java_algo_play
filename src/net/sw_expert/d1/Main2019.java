package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 삼성 SW Expert D1 더블 더블 문제
public class Main2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 2;
        for(int k=2;k<=N;k++){
            dp[k] = dp[k - 1] * 2;
        }
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<=N;k++){
            sb.append(String.format("%d ", dp[k]));
        }
        System.out.println(sb.toString());
    }
}
