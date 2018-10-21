package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Baekjoon 2583 번 문제 풀이
public class Main2583 {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int[][] map;
    static boolean[][] visited;
    static int N, M;
    static boolean isInside(int M, int N, int x, int y){
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }
    static int dfs(int x, int y){
        visited[x][y] = true;
        int result = 1;
        for(int k=0;k<dx.length;k++){
            int tx = x + dx[k];
            int ty = y + dy[k];
            if(isInside(M, N, tx, ty))
                if(!visited[tx][ty] && map[tx][ty] == 0)
                    result += dfs(tx, ty);
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int x=x1;x<x2;x++)
                for(int y=y1;y<y2;y++)
                    map[x][y] = 1;
        }
        PriorityQueue<Integer> results = new PriorityQueue<>();
        for(int k=0;k<N;k++){
            for(int l=0;l<M;l++){
                if(map[k][l] == 0 && !visited[k][l]) {
                    results.offer(dfs(k, l));
                }
            }
        }
        System.out.println(results.size());
        while (!results.isEmpty()) {
            System.out.printf("%d ", results.poll());
        }
    }
}
