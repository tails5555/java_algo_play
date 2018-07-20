package net.sds_academy.type_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] result = new int[T+1];
        int N, M, K;
        for(int k=1;k<=T;k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            boolean[][] edge = new boolean[N+1][N+1];
            boolean[] visited = new boolean[N+1];
            int[] dist = new int[N+1];
            for(int l=0;l<M;l++){
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                edge[y][x] = true;
            }

            Queue<Integer> dfs = new LinkedList<Integer>();
            dfs.offer(1);
            visited[1] = true;
            dist[1] = 0;
            while(!dfs.isEmpty()){
                int tmp = dfs.poll();
                for(int a=1;a<=N;a++){
                    if(edge[tmp][a] == true && !visited[a]){
                        dfs.offer(a);
                        visited[a] = true;
                        dist[a] = dist[tmp] + 1;
                        edge[tmp][a] = false;
                    }
                }
            }
            result[k] = (dist[N] <= K && dist[N] > 0) ? dist[N] : -1;
        }

        for(int k=1;k<=T;k++){
            System.out.printf("#%d %d\n", k, result[k]);
        }
    }
}
