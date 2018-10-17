package net.kang.seoul_to_gyeongsan;

import java.util.Arrays;
import java.util.Scanner;

// 백준 14863번
public class Main {
    static int[] walkTime;
    static int[] walkMoney;
    static int[] bickTime;
    static int[] bickMoney;
    static int[][] dp;
    static boolean[][] visited;
    static int N, K;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        N = s.nextInt();
        K = s.nextInt();

        dp = new int[N+1][K+1];
        visited = new boolean[N+1][K+1];

        walkTime = new int[N];
        walkMoney = new int[N];

        bickTime = new int[N];
        bickMoney = new int[N];

        for(int k=0;k<N;k++){
            walkTime[k] = s.nextInt();
            walkMoney[k] = s.nextInt();

            bickTime[k] = s.nextInt();
            bickMoney[k] = s.nextInt();
        }

        visited[0][0]=true;

        for(int k=0; k<N; k++){
            for(int l=0; l<=K; l++){
                if(visited[k][l]==false) continue;
                if(walkTime[k] + l <= K){
                    dp[k+1][l+walkTime[k]]=Math.max(dp[k+1][l+walkTime[k]], dp[k][l]+walkMoney[k]);
                    visited[k+1][l+walkTime[k]]=true;
                }
                if(bickTime[k]+l <= K){
                    dp[k+1][l+bickTime[k]]=Math.max(dp[k+1][l+bickTime[k]], dp[k][l]+bickMoney[k]);
                    visited[k+1][l+bickTime[k]]=true;
                }
            }
        }

        int m = 0;
        for (int j=0; j<=K; j++){
            m = Math.max(m, dp[N][j]);
        }
        System.out.println(m);

        for(int k=0;k<dp.length;k++){
            System.out.println(Arrays.toString(dp[k]));
        }
    }
}
