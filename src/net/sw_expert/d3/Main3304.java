package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 최장 공통 부분 수열
// 이건 어려워서 풀이 참조 ㅜ
public class Main3304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            char[] a = st.nextToken().toCharArray();
            char[] b = st.nextToken().toCharArray();
            int[][] dp = new int[a.length + 1][b.length + 1];
            for(int l = 0; l <= a.length; l++){
                for(int m = 0; m <= b.length; m++){
                    if( l == 0 || m == 0 ) {
                        dp[l][m] = 0;
                        continue;
                    }
                    if (a[l - 1] == b[m - 1]) {
                        dp[l][m] = dp[l - 1][m - 1] + 1;
                        continue;
                    }
                    dp[l][m] = Math.max(dp[l - 1][m], dp[l][m - 1]);
                }
            }

            System.out.format("#%d %d\n", k + 1, dp[a.length][b.length]);
        }
    }
}
