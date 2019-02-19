package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 장훈이의 높은 선반 문제 풀이
public class Main1486 {
    static int res;
    static int[] emp;
    static int N, B;

    static void backtracking(int idx, int sum){
        if(idx >= N){
            if(sum >= B){
                res = Math.min(res, sum);
            }
            return;
        }
        backtracking(idx + 1, sum + emp[idx]);
        backtracking(idx + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            res = Integer.MAX_VALUE;
            emp = new int[N];
            int idx = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                emp[idx++] = Integer.parseInt(st.nextToken());
            }
            backtracking(0, 0);
            System.out.printf("#%d %d\n", k+1, res - B);
        }
    }
}
