package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 2644번 촌수 계산 문제 풀이
public class Main2644 {
    static final int MAX = 101;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N+1][N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, MAX);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        for(int k=0;k<M;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = true;
        }

        Queue<Integer> bfs = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        bfs.add(from);
        visited[from] = true;
        dist[from] = 0;
        while(!bfs.isEmpty()){
            int tmp = bfs.poll();
            for(int k=1;k<=N;k++){
                if(map[tmp][k] && !visited[k]) {
                    dist[k] = Math.min(dist[k], dist[tmp] + 1);
                    visited[k] = true;
                    bfs.offer(k);
                }
            }
        }

        System.out.println(dist[to] == MAX ? -1 : dist[to]);
    }
}
