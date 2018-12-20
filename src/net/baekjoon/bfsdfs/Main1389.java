package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// Baekjoon 1389번 케빈 베Yee컨의 법칙 문제 풀이
public class Main1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N+1][N+1];
        for(int k=1;k<=M;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end] = map[end][start] = true;
        }

        int result = 0;
        int max = Integer.MAX_VALUE;
        for(int k=1;k<=N;k++){
            int[] dist = new int[N+1];
            Queue<Integer> bfs = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            bfs.offer(k);
            visited.add(k);
            while(!bfs.isEmpty()){
                int vtx = bfs.poll();
                for(int m=1;m<=N;m++){
                    if(!visited.contains(m) && map[vtx][m]){
                        dist[m] += dist[vtx] + 1;
                        bfs.offer(m);
                        visited.add(m);
                    }
                }
            }
            int cnt = 0;
            for(int l=1;l<=N;l++){
                cnt += dist[l];
            }
            if(cnt < max){
                max = cnt;
                result = k;
            }
        }
        System.out.println(result);
    }
}
