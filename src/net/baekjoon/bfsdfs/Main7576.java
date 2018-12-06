package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 7576번 문제
// 2차원 토마토
public class Main7576 {
    static class Pos {
        int n;
        int m;
        int day;
        public Pos(int n, int m, int day){
            this.n = n;
            this.m = m;
            this.day = day;
        }
    }

    public static boolean isInside(int N, int M, int n, int m){
        return (n >= 1 && n <= N) && (m >= 1 && m <= M);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] tomatoes = new int[N+1][M+1];
        for(int k=1;k<=N;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 1;
            while(st.hasMoreTokens()){
                tomatoes[k][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pos> bfs = new LinkedList<Pos>();
        boolean[][] visited = new boolean[N+1][M+1];
        int[] dn = new int[] { 1, 0, -1, 0 };
        int[] dm = new int[] { 0, 1, 0, -1};

        for(int k=1;k<=N;k++){
            for(int l=1;l<=M;l++){
                if(tomatoes[k][l] == 1){
                    bfs.offer(new Pos(k, l, 0));
                    visited[k][l] = true;
                }
            }
        }

        int day = 0;
        while(!bfs.isEmpty()) {
            Pos pos = bfs.poll();
            for (int k = 0; k < dn.length; k++) {
                int tn = pos.n + dn[k];
                int tm = pos.m + dm[k];
                if (isInside(N, M, tn, tm)) {
                    if (!visited[tn][tm] && tomatoes[tn][tm] == 0) {
                        bfs.offer(new Pos(tn, tm, pos.day + 1));
                        visited[tn][tm] = true;
                        tomatoes[tn][tm] = 1;
                    }
                }
            }
            day = Math.max(pos.day, day);
        }

        boolean hasRemain = false;
        for(int k=1;k<=N;k++){
            for(int l=1;l<=M;l++){
                if(tomatoes[k][l] == 0) {
                    hasRemain = true;
                    break;
                }
            }
        }
        System.out.println(hasRemain ? -1 : day);
    }
}
