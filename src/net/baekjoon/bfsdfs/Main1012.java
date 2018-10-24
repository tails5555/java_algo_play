package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 1012 번 고랭지 배추 문제 풀이
public class Main1012 {
    static class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static boolean isInside(int x, int y, int M, int N){
        return (x >= 0 && x < M) && (y >= 0 && y < N);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for(int k=0;k<T;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            boolean[][] graph = new boolean[M][N];
            for(int l=0;l<K;l++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = true;
            }
            int cnt = 0;
            for(int x=0;x<M;x++){
                for(int y=0;y<N;y++){
                    if(graph[x][y]){
                        cnt++;
                        Queue<Pos> queue = new LinkedList<>();
                        queue.offer(new Pos(x, y));
                        graph[x][y] = false;
                        while(!queue.isEmpty()){
                            Pos tmp = queue.poll();
                            for(int z=0;z<4;z++){
                                int tx = tmp.x + dx[z];
                                int ty = tmp.y + dy[z];
                                if(isInside(tx, ty, M, N)){
                                    if(graph[tx][ty]){
                                        queue.offer(new Pos(tx, ty));
                                        graph[tx][ty] = false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}