package net.baekjoon.dp;

import java.util.Scanner;

public class Main2579 {
    static int[] stair;
    static int[][] dp;
    static int N;
    static Scanner s=new Scanner(System.in);
    public static void input(){
        N = s.nextInt();
        stair = new int[N+1];
        dp = new int[N+1][2];
        for(int k=1;k<=N;k++){
            stair[k] = s.nextInt();
        }
        dp[1][0]=dp[1][1]=stair[1];
    }
    public static void main(String[] args){
        input();
        for(int k=2;k<=N;k++){
            dp[k][0] = dp[k-1][1]+stair[k];
            dp[k][1] = Math.max(dp[k-2][0], dp[k-2][1])+stair[k];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }
}
