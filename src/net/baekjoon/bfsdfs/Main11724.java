package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 11724번 연결 요소의 개수 풀이
public class Main11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N+1];
        boolean[][] connections = new boolean[N+1][N+1];

        for(int k=0;k<M;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            connections[start][end] = connections[end][start] = true;
        }

        int cnt = 0;
        for(int k=1;k<=N;k++){
            Queue<Integer> bfs = new LinkedList<>();
            if(!visited[k]) {
                bfs.offer(k);
                visited[k] = true;
                while (!bfs.isEmpty()) {
                    int tmp = bfs.poll();
                    for (int l = 1; l <= N; l++) {
                        if(!visited[l] && connections[tmp][l]){
                            visited[l] = true;
                            bfs.offer(l);
                        }
                    }
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
