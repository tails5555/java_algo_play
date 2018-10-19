package net.baekjoon.dp;

import java.util.Scanner;

// 백준 2193번 문제 풀이
public class Main2193 {
    static int N;
    static long[] dp;
    static Scanner s = new Scanner(System.in);
    public static void input(){
        N = s.nextInt();
        dp = new long[N+1];
    }

    public static void main(String[] args){
        input();
        dp[1]=1;
        for(int k=2;k<=N;k++){
            dp[k]=dp[k-1]+dp[k-2];
        }
        System.out.println(dp[N]);
    }
}
/*
이친수 :
1자리 : 1
2자리 : 10
3자리 : 100, 101
4자리 : 10(00), 10(01), 10(10)
5자리 : 10(100), 10(101), 10(000), 10(001), 10(010)
6자리 : 10(1000), 10(1001), 10(1010), 10(0100), 10(0101), 10(0000), 10(0001), 10(0010)
...
이러한 규칙이 숨어 있다.
 */
