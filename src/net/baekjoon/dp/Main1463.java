package net.baekjoon.dp;

import java.util.Scanner;

// 백준 1463번 문제 풀이
public class Main1463 {
    static final int N = 1000000;
    public static void main(String[] args){
        int[] DP = new int[N+1];
        Scanner s = new Scanner(System.in);
        int rN = s.nextInt();
        for(int k=2;k<=rN;k++){
            DP[k] = DP[k-1] + 1;
            if(k % 2 == 0){
                DP[k] = Math.min(DP[k], DP[k / 2] + 1);
            }
            if(k % 3 == 0){
                DP[k] = Math.min(DP[k], DP[k / 3] + 1);
            }
        }
        System.out.println(DP[rN]);
    }
}
