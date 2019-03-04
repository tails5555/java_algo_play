package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 가능한 셤 점수 문제 풀이
// 이는 DP 를 사용해야 하는 문제로 풀이를 참고했음.
public class Main3752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int[] score = new int[N];

            int total = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                score[l] = Integer.parseInt(st.nextToken());
                total += score[l];
            }

            boolean[] dp = new boolean[total + 100];
            dp[0] = true;

            for(int l = 0; l < N; l++){
                for(int m = total; m >= 0; m--){
                    if(dp[m]) // 가능한 점수가 포함 되어 있으면 더해준 값에 대하여 true 를 한다.
                        dp[score[l] + m] = true;
                }
            }

            int cnt = 0;
            for(int l = 0; l <= total; l++){
                if(dp[l]) cnt += 1;
            }

            System.out.printf("#%d %d\n", k+1, cnt);
        }
    }
}
