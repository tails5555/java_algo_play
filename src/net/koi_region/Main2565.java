package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// Baekjoon KOI 2007 지역본선 초등부 4번 전깃줄 문제 풀이
public class Main2565 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static List<int[]> pair;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        pair = new ArrayList<>();
        pair.add(new int[] { 0, 0 });
        N = Integer.parseInt(br.readLine());
        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            pair.add(new int[] { from, to });
        }

        Collections.sort(pair, Comparator.comparingInt(o -> o[0]));
    }

    static int lis() {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[101];
        dp[0] = 1;

        for(int k = 1; k <= N; k++){
            dp[k] = 1;
            for(int l = 1; l < k; l++) {
                int[] bef = pair.get(k);
                int[] aft = pair.get(l);
                if(aft[1] < bef[1] && dp[k] < (dp[l] + 1)) {
                    dp[k] = dp[l] + 1;
                }
            }
            max = Math.max(max, dp[k]);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(N - lis());
    }
}
