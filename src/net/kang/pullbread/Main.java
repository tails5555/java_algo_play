package net.kang.pullbread;

import java.util.Scanner;

public class Main {
    static int N;
    static Scanner s=new Scanner(System.in);
    static int[] P;
    static long[] dp;
    static void solution() {
        for(int k=1;k<=N;k++) {
            for(int l=1;l<=k;l++) {
                dp[k]=Math.max(dp[k], dp[k-l]+P[l]);
            }
        }
        System.out.println(dp[N]);
    }
    static void input() {
        N=s.nextInt();
        if(N<1 && N>1000) return;
        P=new int[N+1];
        dp=new long[N+1];
        for(int k=1;k<=N;k++) {
            P[k]=s.nextInt();
        }
        solution();
    }
    public static void main(String[] args) {
        input();
    }
}
