package net.kang.nby2_tiles;

import java.util.Scanner;

// 백준 11726번 문제 풀이
public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args){
        int N = s.nextInt();
        long[] dp = new long[N+1];
        dp[0]=1;
        dp[1]=1;
        for(int k=2;k<=N;k++){
            dp[k] = (dp[k-1] + dp[k-2])%10007;
        }
        System.out.println(dp[N]%10007);
    }
}

/*
가로 : W, 세로 : H로 설정
2 * 1 : 1가지[H]
2 * 2 : 2가지[WW, HH]
2 * 3 : 3가지[WWH, HWW, HHH]
2 * 4 : 5가지[WWWW, WWHH, HHWW, HHHH, WHHW]
... 점화식의 와꾸가 나오게 되어 쉽게 풀 수 있다.
 */