package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 2617번 구슬 찾기 문제 풀이
public class Main2617 {
    static int N;
    static boolean[][] map;
    static boolean[] visited;

    static int small, res;
    static int[] bigger;
    static int[] smaller;

    static void dfs(int n){
        visited[n] = true;
        for(int k = 1; k <= N; k++){
            if(map[n][k] && !visited[k]) {
                bigger[k] += 1;
                small += 1;
                dfs(k);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        map = new boolean[N + 1][N + 1];
        int M = Integer.parseInt(st.nextToken());

        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            map[h][l] = true;
        }

        res = 0;
        bigger = new int[N + 1];
        smaller = new int[N + 1];
        for(int k = 1; k <= N; k++){
            visited = new boolean[N + 1];
            small = 0;
            dfs(k);
            smaller[k] = small;
        }

        int ans = 0;
        for (int k = 1; k <= N; k++){
            if (bigger[k] >= (N + 1) / 2 || smaller[k] >= (N + 1) / 2){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
