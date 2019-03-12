package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 백준 3184번 양 문제 풀이
public class Main3184 {
    static char[][] map;
    static int R, C;
    static final int[] dr = { 1, 0, -1, 0 };
    static final int[] dc = { 0, -1, 0, 1 };

    static boolean hasInside(int r, int c){
        return (r >= 0 && r < R && c >= 0 && c < C);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int k = 0; k < R; k++){
            map[k] = br.readLine().toCharArray();
        }

        int sheep = 0, wolf = 0;
        boolean[][] visited = new boolean[R][C];
        for(int r = 0; r < R; r++){
            for(int c = 0; c < C; c++){
                if(map[r][c] != '#' && !visited[r][c]){
                    int s = map[r][c] == 'o' ? 1 : 0, w = map[r][c] == 'v' ? 1 : 0 ;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] { r, c });
                    visited[r][c] = true;

                    while(!queue.isEmpty()){
                        int[] tmp = queue.poll();
                        for(int k = 0; k < dr.length; k++){
                            int tr = tmp[0] + dr[k];
                            int tc = tmp[1] + dc[k];

                            if(hasInside(tr, tc)){
                                if(map[tr][tc] != '#' && !visited[tr][tc]){
                                    visited[tr][tc] = true;
                                    queue.offer(new int[] { tr, tc });
                                    if(map[tr][tc] == 'v'){
                                        w += 1;
                                    } else if(map[tr][tc] == 'o') {
                                        s += 1;
                                    }
                                }
                            }
                        }
                    }

                    if(s > w) {
                        sheep += s;
                    } else {
                        wolf += w;
                    }
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }
}
