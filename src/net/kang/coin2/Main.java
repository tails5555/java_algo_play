package net.kang.coin2;

import java.util.Arrays;
import java.util.Scanner;

// 백준 2294번 문제 풀이
public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        int[] coin = new int[N];
        int[] dp = new int[K+1];
        for(int k=0;k<N;k++){
            coin[k] = s.nextInt();
        }
        Arrays.sort(coin); // 동전의 유무를 확실하게 하기 위해 정렬한다.
        for(int k=1;k<=K;k++){
            dp[k] = Integer.MAX_VALUE; // 처음에는 동전 갯수를 무한대로 설정한다.
            for(int l=0;l<N;l++){ // 각 동전 별로 조사를 시작한다.
                int before = k - coin[l]; // 동전에서 현재 금액에 대해 배제를 하고, 이에 대한 크기를 비교한다.
                if(before >= 0 && dp[before]!=Integer.MAX_VALUE) dp[k] = Math.min(dp[k], dp[before]+1); // 만일 크기 비교도 만족하고, 동전 측정 수가 무한이 아니면, 최솟값을 구해서 계산한다.
            }
        }
        System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);
    }
}

/*
1 -> 1개
2 -> 2개(1+1)
3 -> 3개(1+1+1)
4 -> 4개(1+1+1+1)

5 -> 1개(5)
6 -> 2개(5+1)
7 -> 3개(5+1+1)
...
10 -> 2개(5+5)
11 -> 3개(5+5+1)

12 -> 1개(12)
13 -> 2개(12+1)
14 -> 3개(12+1+1)
...
17 -> 2개(12+5)
*/