package net.baekjoon.floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 1956 번 운동 문제 풀이
public class Main1956 {
    static final int MAX = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        for(int k = 0; k <= N; k++){
            Arrays.fill(map[k], MAX);
        }
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from][to] = weight;
        }

        for(int m = 1; m <= N; m++){
            for(int a = 1; a <= N; a++){
                for(int b = 1; b <= N; b++){
                    if(a == m || a == b || b == m) continue;
                    if(map[a][b] > map[a][m] + map[m][b]) {
                        map[a][b] = map[a][m] + map[m][b];
                    }
                }
            }
        }

        int res = MAX;
        for(int k = 1; k <= N; k++){
            for(int l = k + 1; l <= N; l++){
                if(map[k][l] != MAX && map[l][k] != MAX) {
                    res = Math.min(res, map[k][l] + map[l][k]);
                }
            }
        }

        System.out.println(res == MAX ? -1 : res);
    }
}
