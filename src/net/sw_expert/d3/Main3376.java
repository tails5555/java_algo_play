package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 파도반 수열 문제 풀이
// DP 는 걍 안전하게 long 으로 하는 것이 장땡인듯 하다.
public class Main3376 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            if(dp[N] != 0) {
                System.out.printf("#%d %d\n", k+1, dp[N]);
            } else {
                for(int l = 4; l <= N; l++){
                    if(dp[l] == 0)
                        dp[l] = dp[l - 2] + dp[l - 3];
                }
                System.out.printf("#%d %d\n", k+1, dp[N]);
            }
        }
    }
}

// p1 ~ p3 = 1
// p4 = p1 + p2 = 2
// p5 = p2 + p3 = 2
// p6 = p3 + p4 = 3
// p7 = p4 + p5 = 4
// p8 = p5 + p6 = 5
// p9 = p6 + p7 = 7
// p10 = p7 + p8 = 9