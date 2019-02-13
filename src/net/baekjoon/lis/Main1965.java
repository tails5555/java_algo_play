package net.baekjoon.lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1965 번 문제
public class Main1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] boxes = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while(st.hasMoreTokens()) {
            boxes[idx++] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int[] dp = new int[boxes.length];
        dp[0] = 1;

        for(int k = 1; k < boxes.length; k++){
            dp[k] = 1;
            for(int l = 0; l < k; l++) {
                if(boxes[k] > boxes[l] && dp[k] < (dp[l] + 1)) {
                    dp[k] = dp[l] + 1;
                }
            }
            max = Math.max(max, dp[k]);
        }

        System.out.println(max);
    }
}
