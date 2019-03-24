package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D4 지희의 고장난 계산기 문제 풀이
public class Main1808 {
    static int[] dp;

    static int count(int num) {
        int cnt = 0;

        int tmp = num;
        while(tmp > 0){
            int c = tmp % 10;
            if(dp[c] == Integer.MAX_VALUE) return Integer.MAX_VALUE;
            tmp /= 10;
            cnt += 1;
        }

        return cnt;
    }

    static int dynamic_programming(int num) {
        if(dp[num] != 0) return dp[num];

        dp[num] = count(num);
        for(int k = 1; k <= (int) Math.sqrt(num); k++){
            if(num % k == 0) {
                int tmp1 = dynamic_programming(k);
                int tmp2 = dynamic_programming(num / k);

                dp[num] = Math.min(dp[num], (tmp1 == Integer.MAX_VALUE || tmp2 == Integer.MAX_VALUE) ? Integer.MAX_VALUE : tmp1 + tmp2 + 1);
            }
        }

        return dp[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");

            Set<Integer> btn = new HashSet<>();
            for(int l = 0; l < 10; l++){
                if(st.nextToken().equals("1"))
                    btn.add(l);
            }

            int c = Integer.parseInt(br.readLine());
            dp = new int[c + 10];
            for(int l = 0; l <= 9; l++){
                if(btn.contains(l)) dp[l] = 1;
                else dp[l] = Integer.MAX_VALUE;
            }

            dynamic_programming(c);
            System.out.printf("#%d %d\n", k + 1, dp[c] == Integer.MAX_VALUE ? -1 : dp[c] + 1);
        }
    }
}
