package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 9251. LCS 문제 풀이
public class Main9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int k=1;k<=s1.length();k++){
            char c1 = s1.charAt(k - 1);
            for(int l=1;l<=s2.length();l++) {
                char c2 = s2.charAt(l - 1);
                if (c1 == c2) dp[k][l] = dp[k - 1][l - 1] + 1;
                else dp[k][l] = Math.max(dp[k - 1][l], dp[k][l - 1]);
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }
}
