package net.baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

// 백준 1699번 문제 풀이 완료
public class Main1699 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] dp = new int[N+1];
        for(int k=1;k<=N;k++){
            dp[k] = k;
            for(int l=1;l*l<=k;l++){
                dp[k] = Math.min(dp[k], dp[k-l*l]+1);
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[N]);
    }
}
/*
1 -> 1^2
2 -> 1^2 + 1^2
3 -> 1^2 + 1^2 + 1^2

4 -> 2^2
5 -> 2^2 + 1^2(1)
6 -> 2^2 + 1^2 + 1^2(2)
7 -> 2^2 + 1^2 + 1^2 + 1^2(3)
8 -> 2^2 + 2^2(4)

9 -> 3^2
10 -> 3^2 + 1^2(1)
11 -> 3^2 + 1^2 + 1^2(2)
12 -> 2^2 + 2^2 + 2^2

13 -> 3^2 + 2^2(4)
14 -> 3^2 + 2^2 + 1^2(5)
15 -> 3^2 + 2^2 + 1^2 + 1^2(6)

16 -> 4^2
17 -> 4^2 + 1^2(1)
18 -> 3^2 + 3^2
19 -> 3^2 + 3^2 + 1
20 -> 4^2 + 2^2(4)


 */