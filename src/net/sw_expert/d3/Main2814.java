package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 최장 경로 문제 풀이
public class Main2814 {
    static boolean[][] map;
    static boolean[] visited;
    static int res;

    static void dfs(int length, int idx) {
        res = Math.max(length, res);
        visited[idx] = true;
        for(int k = 1; k < visited.length; k++){
            if(!visited[k] && map[idx][k]) {
                dfs(length + 1, k);
            }
        }
        visited[idx] = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            map = new boolean[N + 1][N + 1];

            for(int l = 0; l < M; l++){
                st = new StringTokenizer(br.readLine(), " ");

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                map[from][to] = map[to][from] = true;
            }

            res = Integer.MIN_VALUE;
            visited = new boolean[N + 1];
            for(int l = 1; l <= N; l++){
                dfs(1, l);
            }

            System.out.printf("#%d %d\n", k + 1, res);
        }
    }
}
