package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 14502 연구소 문제 풀이
public class Main14502 {
    static int N, M;
    static int[][] map;
    static int[][] test;
    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };
    static int result = Integer.MIN_VALUE;

    public static boolean hasInside(int y, int x){
        return (y >= 0 && y < N) && (x >= 0 && x < M);
    }

    public static void reset(){
        for(int k=0;k<N;k++){
            for(int l=0;l<M;l++){
                test[k][l] = map[k][l];
            }
        }
    }

    public static void spread(int y, int x){
        for(int k=0;k<dy.length;k++){
            int ty = y + dy[k];
            int tx = x + dx[k];
            if(hasInside(ty, tx)){
                if(test[ty][tx] == 0){
                    test[ty][tx] = 2;
                    spread(ty, tx);
                }
            }
        }
    }

    public static int count(){
        int cnt = 0;
        for(int k=0;k<N;k++){
            for(int l=0;l<M;l++){
                if(test[k][l] == 0)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void wall(int v, int cnt){
        if(cnt == 3){
            test = new int[N][M];
            reset();

            for(int k=0;k<N;k++){
                for(int l=0;l<M;l++){
                    if(test[k][l] == 2){
                        spread(k, l);
                    }
                }
            }

            result = Math.max(result, count());
        } else {
            for(int k = v+1;k<N*M;k++){
                int ty = k / M;
                int tx = k % M;
                if(map[ty][tx] == 0){
                    map[ty][tx] = 1;
                    wall(k, cnt + 1);
                    map[ty][tx] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int k=0;k<N;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while(st.hasMoreTokens()){
                map[k][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0;k<N*M;k++){
            int ty = k / M;
            int tx = k % M;

            if(map[ty][tx] == 0){
                map[ty][tx] = 1;
                wall(k, 1);
                map[ty][tx] = 0;
            }
        }
        System.out.println(result);
    }
}
