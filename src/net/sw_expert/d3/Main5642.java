package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 그냥 "합" 문제 풀이
public class Main5642 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];
            st = new StringTokenizer(br.readLine(), " ");

            int res = Integer.MIN_VALUE;
            for(int l = 1; l <= N; l++){
                dp[l] = Integer.parseInt(st.nextToken());
                dp[l] = Math.max(dp[l], dp[l] + dp[l - 1]);
                res = Math.max(res, dp[l]);
            }
            System.out.printf("#%d %d\n", k + 1, res);
        }
    }
}
