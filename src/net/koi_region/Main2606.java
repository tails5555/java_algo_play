package net.koi_region;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2004 초등부 지역 본선 3번 바이러스 문제 풀이
public class Main2606 {
    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static boolean[] visited;
    static boolean[][] map;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        map = new boolean[N + 1][N + 1];
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = map[to][from] = true;
        }
    }

    static void initialize() {
        visited = new boolean[N + 1];
    }

    static void dfs(int r){
        visited[r] = true;

        for(int k = 1; k <= N; k++){
            if(map[r][k] && !visited[k]) {
                dfs(k);
            }
        }
    }

    static void result() {
        int count = 0;
        for(int k = 2; k <= N; k++){
            count += visited[k] ? 1 : 0;
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws IOException {
        input();
        initialize();
        dfs(1);
        result();
    }
}
