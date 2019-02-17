package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 LIS 문제 풀이
// 이젠 안 보고 해 보는 게 낫지 않겄어? DP 로 구하는 방법만이라도 알아두자.
public class Main3307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while(st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
            dp[0] = 1;

            int max = Integer.MIN_VALUE;
            for(int l = 1; l < dp.length; l++){
                dp[l] = 1;
                for(int m = 0; m < l; m++){
                    if (arr[l] > arr[m] && dp[l] < dp[m] + 1) {
                        dp[l] = dp[m] + 1;
                    }
                }
                max = Math.max(max, dp[l]);
            }

            System.out.printf("#%d %d\n", k+1, max);
        }
    }
}
