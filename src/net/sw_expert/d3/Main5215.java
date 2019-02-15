package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 햄버거 다Yee어트 문제 풀이
public class Main5215 {
    static int[] calories, score;
    static int limit;
    static int max;

    static void backtracking(int idx, int sum, int calorie) {
        if(idx >= calories.length) {
            if(calorie <= limit)
                max = Math.max(max, sum);
            return;
        }
        backtracking(idx + 1, sum + score[idx], calorie + calories[idx]);
        backtracking(idx + 1, sum, calorie);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            limit = Integer.parseInt(st.nextToken());
            calories = new int[N + 1];
            score = new int[N + 1];
            for(int l = 1; l <= N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                score[l] = Integer.parseInt(st.nextToken());
                calories[l] = Integer.parseInt(st.nextToken());
            }
            backtracking(0, 0, 0);
            System.out.printf("#%d %d\n", k+1, max);
        }
    }
}
