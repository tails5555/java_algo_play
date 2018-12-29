package net.baekjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 1238 파티 문제 풀이
public class Main1238 {
    static final int MAX = 1000 * 10000 + 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][N+1];
        for(int k=1;k<=N;k++){
            for(int l=1;l<=N;l++){
                if(k != l)
                    map[k][l] = MAX;
            }
        }

        for(int k=0;k<M;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            map[n][m] = Math.min(map[n][m], len);
        }

        for(int m=1;m<=N;m++){
            for(int a=1;a<=N;a++){
                for(int b=1;b<=N;b++){
                    if(a == m || b == m || a == b) continue;
                    map[a][b] = Math.min(map[a][b], map[a][m] + map[m][b]);
                }
            }
        }

        int res = 0;
        for(int k=1;k<=N;k++){
            res = Math.max(res, map[k][x] + map[x][k]);
        }
        System.out.println(res);
    }
}
