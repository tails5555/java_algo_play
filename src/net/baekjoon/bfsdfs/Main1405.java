package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1405 번 미친 로봇 문제 풀이
public class Main1405 {
    static int N;
    static int[] per = new int[4];
    static final int[] dx = { 1, -1, 0,  0 };
    static final int[] dy = { 0,  0, 1, -1 };
    static boolean[][] visited;

    static double backtracking(int x, int y, int cnt){
        if(cnt == N) return 1.0;
        double res = 0;
        visited[x][y] = true;
        for(int k = 0; k < dx.length; k++){
            int tx = dx[k] + x;
            int ty = dy[k] + y;
            if(!visited[tx][ty])
                res += (((double) per[k] / 100.0) * backtracking(tx, ty, cnt + 1));
        }
        visited[x][y] = false;
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        for(int k = 0; k < 4; k++){
            per[k] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[29][29];
        System.out.println(backtracking(14, 14, 0));
    }
}
