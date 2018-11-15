package net.baekjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 11404번 플로이드 문제 풀이
public class Main11404 {
    static final int MAXIMUM = 100000 * 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] times = new int[N+1][N+1];

        for(int k=1;k<=N;k++){
            for(int l=1;l<=N;l++){
                times[k][l] = k == l ? 0 : MAXIMUM;
            }
        }

        StringTokenizer st;
        for(int k=0;k<M;k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            times[from][to] = Math.min(value, times[from][to]);
        }

        for(int m=1;m<=N;m++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    times[i][j] = Math.min(times[i][j], times[i][m] + times[m][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int k=1;k<=N;k++){
            for(int l=1;l<=N;l++){
                sb.append(String.format("%d ", times[k][l] != MAXIMUM ? times[k][l] : 0));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
