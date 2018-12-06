package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7569 {
    static class Pos {
        int h;
        int n;
        int m;
        int day;
        public Pos(int h, int n, int m, int day){
            this.h = h;
            this.n = n;
            this.m = m;
            this.day = day;
        }
    }

    public static boolean isInside(int H, int N, int M, int h, int n, int m){
        return (h >= 1 && h <= H) && (n >= 1 && n <= N) && (m >= 1 && m <= M);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][][] tomatoes = new int[H+1][N+1][M+1];
        for(int k=1;k<=H;k++){
            for(int l=1;l<=N;l++) {
                st = new StringTokenizer(br.readLine(), " ");
                int idx = 1;
                while (st.hasMoreTokens()) {
                    tomatoes[k][l][idx++] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<Pos> bfs = new LinkedList<Pos>();
        boolean[][][] visited = new boolean[H+1][N+1][M+1];
        int[] dh = new int[] { 0, 0, 1, 0, 0, -1 };
        int[] dn = new int[] { 1, 0, 0, -1, 0, 0 };
        int[] dm = new int[] { 0, 1, 0, 0, -1, 0 };

        for(int k=1;k<=H;k++){
            for(int l=1;l<=N;l++){
                for(int m=1;m<=M;m++) {
                    if (tomatoes[k][l][m] == 1) {
                        bfs.offer(new Pos(k, l, m, 0));
                        visited[k][l][m] = true;
                    }
                }
            }
        }

        int day = 0;
        while(!bfs.isEmpty()) {
            Pos pos = bfs.poll();
            for (int k = 0; k < dh.length; k++) {
                int th = pos.h + dh[k];
                int tn = pos.n + dn[k];
                int tm = pos.m + dm[k];
                if (isInside(H, N, M, th, tn, tm)) {
                    if (!visited[th][tn][tm] && tomatoes[th][tn][tm] == 0) {
                        bfs.offer(new Pos(th, tn, tm, pos.day + 1));
                        visited[th][tn][tm] = true;
                        tomatoes[th][tn][tm] = 1;
                    }
                }
            }
            day = Math.max(pos.day, day);
        }

        boolean hasRemain = false;
        for(int k=1;k<=H;k++){
            for(int l=1;l<=N;l++){
                for(int m=1;m<=M;m++) {
                    if (tomatoes[k][l][m] == 0) {
                        hasRemain = true;
                        break;
                    }
                }
            }
        }
        System.out.println(hasRemain ? -1 : day);
    }
}
