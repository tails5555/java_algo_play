package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2016 초등부 리조트 문제 풀이
// DP 를 공부하기 위하여 풀이를 참조했습니당...ㅜ
public class Main13302 {
    static final int INFINITE = 987654321;
    static final int ONE_DAY = 10000;
    static final int THREE_DAY = 25000;
    static final int FIVE_DAY = 37000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] hasNotOpen = new boolean[100 + 5 + 1];
        if(M != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int k = 0; k < M; k++) {
                int tmp = Integer.parseInt(st.nextToken());
                hasNotOpen[tmp] = true;
            }
        }

        int[][] dp = new int[100 + 5 + 1][100 + 5 + 1];
        for (int k = 1; k <= N; k++) {
            for (int l = 0; l < N; l++) {
                dp[k][l] = INFINITE;
            }
        }

        dp[0][0] = 0;
        for(int k = 0; k <= N; k++){
            for(int l = 0; l <= k; l++){
                if(dp[k][l] == INFINITE) continue;
                int cur = dp[k][l];
                if(hasNotOpen[k + 1]) {
                    dp[k + 1][l] = Math.min(cur, dp[k + 1][l]);
                }
                if(l >= 3) {
                    dp[k + 1][l - 3] = Math.min(cur, dp[k + 1][l - 3]);
                }
                dp[k + 1][l] = Math.min(cur + ONE_DAY, dp[k + 1][l]);
                for (int m = 1; m <= 3; m++) {
                    dp[k + m][l + 1] = Math.min(cur + THREE_DAY, dp[k + m][l + 1]);
                }
                for (int m = 1; m <= 5; m++) {
                    dp[k + m][l + 2] = Math.min(cur + FIVE_DAY, dp[k + m][l + 2]);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int k = 0; k < N; k++) {
            res = Math.min(dp[N][k], res);
        }
        System.out.println(res);
    }
}
