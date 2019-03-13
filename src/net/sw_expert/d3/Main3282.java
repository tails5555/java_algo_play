package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SW Expert D3 0/1 Knapsack 문제 풀이
public class Main3282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] dp;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            dp = new int[N + 1][K + 1];

            int[] v = new int[N + 1];
            int[] c = new int[N + 1];

            for(int l = 1; l <= N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                v[l] = Integer.parseInt(st.nextToken());
                c[l] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= K; j++){
                    if(v[i] > j) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = Math.max(dp[i - 1][j], c[i] + dp[i - 1][j - v[i]]);
                }

                for(int[] d : dp){
                    System.out.println(Arrays.toString(d));
                }

            }

            System.out.printf("#%d %d\n", k + 1, dp[N][K]);
        }
    }
}

/*
 * Knapsack Algorithm
 *
 * K C
 * 1 2
 * 3 2
 * 4 4
 * 2 3
 *
 * N = 1
 * - - - - - -
 * - 2 2 2 2 2
 * - 0 0 0 0 0
 * - 0 0 0 0 0
 * - 0 0 0 0 0
 *
 * N = 2
 * - - - - - -
 * - 2 2 2 2 2
 * - 2 2 2 4 4
 * - 0 0 0 0 0
 * - 0 0 0 0 0
 *
 * N = 3
 * - - - - - -
 * - 2 2 2 2 2
 * - 2 2 2 4 4
 * - 2 2 2 4 6
 * - 0 0 0 0 0
 *
 * N = 4
 * - - - - - -
 * - 2 2 2 2 2
 * - 2 2 2 4 4
 * - 2 2 2 4 6
 * - 2 3 5 5 6
 */