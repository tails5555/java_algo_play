package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 7562번 Knight 의 Yee동 문제 풀Yee
public class Main7562 {
    static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static int[] dy = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int L;
    static boolean[][] map;

    static boolean hasInside(int x, int y) {
        return (x >= 0 && x < L) && (y >= 0 && y < L);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[] start, end;
        StringTokenizer st;
        for(int t=0;t<T;t++){
            L = Integer.parseInt(br.readLine());

            map = new boolean[L][L];
            start = new int[3];
            end = new int[2];

            st = new StringTokenizer(br.readLine(), " ");
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            Queue<int[]> bfs = new LinkedList<>();
            bfs.offer(start);
            map[start[0]][start[1]] = true;

            int cnt = 0;
            while(!bfs.isEmpty()) {
                int[] tmp = bfs.poll();
                if(tmp[0] == end[0] && tmp[1] == end[1]) {
                    cnt = tmp[2];
                    break;
                }
                for(int k=0;k<dx.length;k++){
                    int tx = tmp[0] + dx[k];
                    int ty = tmp[1] + dy[k];
                    if(hasInside(tx, ty) && !map[tx][ty]) {
                        map[tx][ty] = true;
                        bfs.offer(new int[] { tx, ty, tmp[2] + 1 });
                    }
                }
            }
            bw.write(String.format("%d\n", cnt));
        }

        bw.flush();
    }
}
