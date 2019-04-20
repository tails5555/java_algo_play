package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon KOI 2005 초등부 지역본선 5번 숫자카드 문제 풀이
public class Main2591 {
    static BufferedReader br;
    static String s;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
    }

    static void solution() {
        char[] arr = s.toCharArray();
        int[][] dp = new int[41][3];
        int bef = (arr[0] - '0') * 10;
        dp[1][1] = 1;
        for(int k = 2; k <= arr.length; k++){
            int tmp = arr[k - 1] - '0';
            if(tmp == 0) {
                if(bef + tmp <= 34){
                    dp[k][2] = dp[k - 1][1];
                }
                continue;
            }

            if(bef + tmp <= 34){
                dp[k][1] = dp[k - 1][2] + dp[k - 1][1];
                dp[k][2] = dp[k - 1][1];
            } else {
                dp[k][1] = dp[k - 1][2] + dp[k - 1][1];
            }
            bef = tmp * 10;
        }

        System.out.println(dp[arr.length][1] + dp[arr.length][2]);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
