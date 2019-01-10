package net.baekjoon.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 2629번 문제 풀이
public class Main2629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int W = Integer.parseInt(br.readLine());
        int[] weight = new int[W+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int k=1;k<=W;k++){
            weight[k] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[31][30001];
        int[] check = { -1, 0, 1 };

        dp[0][15000] = true;
        for(int i = 1; i <= W; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k <= 30000; k++) {
                    int tt = weight[i] * check[j] + k;
                    if(tt >= 0 && tt <= 30000)
                        dp[i][tt] = dp[i][tt] || dp[i - 1][k];
                }
            }
        }

        int N = Integer.parseInt(br.readLine());
        int[] curious = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int k=0;k<N;k++){
            curious[k] = Integer.parseInt(st.nextToken());
        }

        for(int k=0;k<curious.length;k++){
            if(curious[k] + 15000 <= 30000) {
                if (dp[W][curious[k] + 15000])
                    System.out.print("Y ");
                else
                    System.out.print("N ");
            } else {
                System.out.print("N ");
            }
        }
    }
}
