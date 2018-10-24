package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 2178번 문제 풀이
public class Main2178_1 {
    static boolean[][] graph;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int result = Integer.MAX_VALUE;
    public static boolean isInside(int y, int x, int N, int M){
        return (y >= 1 && y < N) && (x >= 1 && x < M);
    }

    public static void dfs(int y, int x, int cnt){
        if(y == graph.length - 1 && x == graph[0].length - 1){
            if(result > cnt)
                result = cnt;
        }
        graph[y][x] = false;
        for (int k = 0; k < 4; k++) {
            int ty = dy[k] + y;
            int tx = dx[k] + x;
            if (isInside(ty, tx, graph.length, graph[0].length)) {
                if (graph[ty][tx]) {
                    dfs(ty, tx, cnt + 1);
                }
            }
        }
        graph[y][x] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new boolean[N+1][M+1];
        for(int k=1;k<=N;k++){
            String str = br.readLine();
            char[] charr = str.toCharArray();
            for(int l=0;l<charr.length;l++){
                graph[k][l+1] = (charr[l] == '1');
            }
        }
        dfs(1, 1, 1);
        System.out.println(result);
    }
}
