package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 11066 번 문제 풀이
// DP 문제는 하루에 한 문제씩이라도 풀 생각임.
public class Main11066 {
    static int[] chapters;
    static int[] sum;
    static int[][] dp;

    static int solution(int start, int end) {
        if(start >= end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        if(Math.abs(start - end) == 1) return chapters[start] + chapters[end];
        dp[start][end] = Integer.MAX_VALUE;
        for(int k = start; k <= end; k++){
            int tmp = solution(start, k) + solution(k + 1, end) + sum[end] - sum[start - 1];
            dp[start][end] = Math.min(dp[start][end], tmp);
        }
        return dp[start][end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            int idx = 1;
            sum = new int[N + 1];
            chapters = new int[N + 1];
            while(st.hasMoreTokens()) {
                chapters[idx] = Integer.parseInt(st.nextToken());
                sum[idx] = sum[idx - 1] + chapters[idx];
                idx += 1;
            }

            dp = new int[N + 1][N + 1];

            for(int[] d : dp)
                Arrays.fill(d, -1);

            System.out.println(solution(1, N));
        }
    }
}

/*
 * 40 / 30 30 50 (0 0) (1 3)
 * 40 30 / 30 50 (0 1) (2 3)
 * 40 30 30 / 50 (0 2) (3 3)
 * 범위에 따른 부분합의 원리를 잘 이용할 수 있는가를 질문하였음. 다시 풀어보는 것이 좋을 듯.
 */
