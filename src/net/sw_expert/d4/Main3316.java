package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D4 동아리실 관리하기 문제 풀이
// 다음에 풀어보겠습니다...
public class Main3316 {
    static final char[] members = { 'A', 'B', 'C', 'D' };
    static char[] tmp;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            tmp = br.readLine().toCharArray();
            long[][] dp = new long[tmp.length + 1][4];
            dp[0][0] = 1L;
            dp[0][1] = dp[0][2] = dp[0][3] = 2L;
            for(int l = 1; l <= tmp.length; l++){

            }
        }
    }
}
