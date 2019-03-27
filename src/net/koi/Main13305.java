package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2016 중등부 주유소 문제 풀이
public class Main13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N];
        int idx = 0;
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            dist[idx++] = Long.parseLong(st.nextToken());
        }

        long[] price = new long[N];
        idx = 0;
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            price[idx++] = Long.parseLong(st.nextToken());
        }

        long[] dp = new long[N];
        dp[0] = price[0] * dist[0];
        long min = price[0];
        for(int k = 1; k < N; k++){
            if(price[k] < min){
                min = price[k];
            }
            dp[k] = dp[k - 1] + min * dist[k];
        }

        System.out.println(dp[N - 1]);
    }
}
