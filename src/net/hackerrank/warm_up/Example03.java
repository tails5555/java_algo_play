package net.hackerrank.warm_up;

import java.util.Arrays;

// Hacker Rank Warm Up 문제
// Jumpin' On The Cloud(손오공) 문제
// 최소한의 점프 횟수를 구하는 문제
public class Example03 {
    static int jumpingOnClouds(int[] c) {
        int[] dp = new int[c.length];
        Arrays.fill(dp, 101);

        dp[0] = 0;
        for(int k=0;k<c.length;k++){
            for(int l=0;l<=1;l++){
                int tmp = k + (l + 1);
                if(tmp < c.length){
                    if(c[tmp] != 1)
                        dp[tmp] = Math.min(dp[tmp], dp[k] + 1);
                }
            }
        }
        return dp[c.length - 1];
    }

    public static void main(String[] args){
        System.out.println(jumpingOnClouds(new int[] { 0, 0, 1, 0, 0, 1, 0 }));
        System.out.println(jumpingOnClouds(new int[] { 0, 0, 0, 0, 1, 0 }));
    }
}
