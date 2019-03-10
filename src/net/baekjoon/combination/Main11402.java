package net.baekjoon.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 11402 번 이항계수 4 문제 풀이
// 뤼카의 정리를 활용해야 제대로 풀 수 있는 문제
public class Main11402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long N = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[M + 1][M + 1];
        for(int k = 0; k <= M; k++) {
            for(int l = 0; l <= k; l++){
                if(l == 0 || l == k)
                    dp[k][l] = 1;
                else
                    dp[k][l] = (dp[k - 1][l - 1] + dp[k - 1][l]) % M;
            }
        }

        long res = 1L;
        while(N > 0 || R > 0){
            long n = N % M;
            long r = R % M;
            res = (res * dp[(int) n][(int) r]) % M;
            N /= M;
            R /= M;
        }

        System.out.println(res);
    }
}
