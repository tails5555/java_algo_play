package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 11049 행렬 곱셈 순서 문제 풀이
public class Main11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][2];
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            matrix[k] = new int[] { m, n };
        }

        int[][] dp = new int[N][N];
        for(int diff = 1; diff < N; diff++){
            for(int start = 0; start < N - diff; start++){
                int end = start + diff;
                dp[start][end] = Integer.MAX_VALUE;
                for(int mid = start; mid < end; mid++){
                    int cnt = dp[start][mid];
                    cnt += dp[mid + 1][end];
                    cnt += (matrix[start][0] * matrix[mid][1] * matrix[end][1]);
                    dp[start][end] = Math.min(dp[start][end], cnt);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}
