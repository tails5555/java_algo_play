package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 2589번 보물섬 문제 풀이
public class Main2589 {
    static int R, C;
    static final int[] dr = { 1, -1, 0, 0 };
    static final int[] dc = { 0, 0, 1, -1 };
    static boolean hasInside(int r, int c){
        return (r >= 0) && (r < R) && (c >= 0) && (c < C);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        for(int k = 0; k < R; k++){
            map[k] = br.readLine().toCharArray();
        }

        int res = Integer.MIN_VALUE;
        for(int k = 0; k < R; k++){
            for(int l = 0; l < C; l++){
                if(map[k][l] == 'L'){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] { k, l, 0 });
                    boolean[][] visited = new boolean[R][C];
                    visited[k][l] = true;
                    int dist = Integer.MIN_VALUE;
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        dist = Math.max(cur[2], dist);
                        for(int m = 0; m < dr.length; m++){
                            int tr = cur[0] + dr[m];
                            int tc = cur[1] + dc[m];
                            if(hasInside(tr, tc)){
                                if(map[tr][tc] == 'L' && !visited[tr][tc]) {
                                    queue.offer(new int[] { tr, tc, cur[2] + 1 });
                                    visited[tr][tc] = true;
                                }
                            }
                        }
                    }

                    res = Math.max(res, dist);
                }
            }
        }

        System.out.println(res);
    }
}
