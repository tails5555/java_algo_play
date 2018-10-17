package net.kang.rgb_question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1149번 RGB 거리 문제
public class Main {
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][3];
        long min = 0;

        for(int k=1;k<=N;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long[] value = new long[3];
            int idx = 0;
            while(st.hasMoreTokens())
                value[idx++] = Long.parseLong(st.nextToken());

            long curMin = Long.MAX_VALUE;
            for (int l = 0; l <= 2; l++) {
                if(l == RED)
                    dp[k][l] = Math.min(dp[k-1][BLUE], dp[k-1][GREEN]) + value[l];
                else if(l == GREEN)
                    dp[k][l] = Math.min(dp[k-1][BLUE], dp[k-1][RED]) + value[l];
                else
                    dp[k][l] = Math.min(dp[k-1][RED], dp[k-1][GREEN]) + value[l];
                if(dp[k][l] < curMin) {
                    curMin = dp[k][l];
                }
            }
            min = curMin;
        }
        System.out.println(min);
    }
}
