package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 다슬이의 일 분배 문제 풀이
public class Main1865 {
    static int N;
    static boolean[] visited;
    static double[][] success;
    static double result;

    static void backtracking(int idx, double percentage){
        if(result >= percentage) return;
        if(idx == N){
            result = Math.max(result, percentage);
            return;
        }

        for(int k = 0; k < N; k++){
            if(!visited[k]){
                visited[k] = true;
                backtracking(idx + 1, percentage * success[idx][k]);
                visited[k] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            N = Integer.parseInt(br.readLine());
            success = new double[N][N];
            visited = new boolean[N];
            result = Double.MIN_VALUE;
            for(int l = 0; l < N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int m = 0; m < N; m++){
                    success[l][m] = (double) Integer.parseInt(st.nextToken()) / 100.0;
                }
            }
            backtracking(0, 1);
            System.out.printf("#%d %.6f\n", k+1, result * 100);
        }
    }
}
