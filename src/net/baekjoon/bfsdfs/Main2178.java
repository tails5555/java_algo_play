package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 2178번 문제 풀이
public class Main2178 {
    static boolean[][] graph;
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    public static boolean isInside(int y, int x, int N, int M){
        return (y >= 1 && y <= N) && (x >= 1 && x <= M);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new boolean[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int k=1;k<=N;k++){
            String str = br.readLine();
            char[] charr = str.toCharArray();
            for(int l=0;l<charr.length;l++){
                graph[k][l+1] = (charr[l] == '1');
            }
        }

        int count = Integer.MAX_VALUE;
        Queue<int[]> bfs = new LinkedList<>();
        bfs.offer(new int[] { 1, 1, 1 });
        visited[1][1] = true;
        while(!bfs.isEmpty()) {
            int[] tmp = bfs.poll();
            if(tmp[0] == N && tmp[1] == M) {
                count = Math.min(count, tmp[2]);
                break;
            }

            for(int k=0;k<dx.length;k++){
                int ty = tmp[0] + dy[k];
                int tx = tmp[1] + dx[k];
                if(isInside(ty, tx, N, M)) {
                    if(graph[ty][tx] && !visited[ty][tx]) {
                        visited[ty][tx] = true;
                        bfs.offer(new int[] { ty, tx, tmp[2] + 1 });
                    }
                }
            }
        }

        System.out.println(count);
    }
}
