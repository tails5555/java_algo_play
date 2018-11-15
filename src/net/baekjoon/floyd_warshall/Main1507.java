package net.baekjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 1507 궁금한 민호 문제 풀이
public class Main1507 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] beforeMap = new int[N+1][N+1];
        int[][] newMap = new int[N+1][N+1];

        StringTokenizer st;
        for(int k=1;k<=N;k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 1;
            while(st.hasMoreTokens()){
                beforeMap[k][idx] = newMap[k][idx] = Integer.parseInt(st.nextToken());
                idx++;
            }
        }

        for(int m=1;m<=N;m++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(i == j || i == m || j == m) continue;
                    if(beforeMap[i][j] == beforeMap[i][m] + beforeMap[m][j]) {
                        newMap[i][j] = 0;
                    } else if(beforeMap[i][j] > beforeMap[i][m] + beforeMap[m][j]) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        int sum = 0;
        for (int k = 1; k <= N; k++) {
            for (int l = k; l <= N; l++) {
                sum += newMap[k][l];
            }
        }
        System.out.println(sum);
    }
}
