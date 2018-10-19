package net.baekjoon.dp;

import java.util.Scanner;

// 백준 11727번 문제 풀이
public class Main11727 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        long[] dp = new long[N+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int k=2;k<=N;k++){
            dp[k] = (dp[k-1] + 2*dp[k-2])%10007;
        }
        System.out.println(dp[N]);
    }
}

/*
가로 : W, 세로 : H, 정사각형 : S
2 * 1 => H 1개
2 * 2 => HH, WW, S 3개
2 * 3 => HHH, HWW, HS, WWH, SH 5개
2 * 4 => HHHH, HHWW, HHS, WWHH, WWWW, WWS, SHH, SWW, SS, HSH, HWWH 11개
...
2 * n => a[n-1] + 2*a[n-2) 도출 가능
 */