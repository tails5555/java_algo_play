package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// SW Expert D4 보급로 문제 풀이
// 풀Yee참조 ㅜ
public class Main1249 {
    static final int[] dr = { 1, 0, -1, 0 };
    static final int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for (int l = 0; l < N; l++) {
                char[] c = br.readLine().toCharArray();
                for (int m = 0; m < N; m++) {
                    map[l][m] = c[m] - '0';
                }
            }

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] { 0, 0 });
            int[][] cost = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            while(!queue.isEmpty()){
                int[] tmp = queue.poll();
                int tr = tmp[0];
                int tc = tmp[1];
                for (int l = 0; l < dr.length; l++) {
                    int tmpR = tr + dr[l];
                    int tmpC = tc + dc[l];
                    if ((tmpR >= 0 && tmpR < N) && (tmpC >= 0 && tmpC < N)) {
                        if (!visited[tmpR][tmpC] || cost[tmpR][tmpC] > cost[tr][tc] + map[tmpR][tmpC]) {
                            cost[tmpR][tmpC] = cost[tr][tc] + map[tmpR][tmpC];
                            visited[tmpR][tmpC] = true;
                            queue.offer(new int[]{ tmpR, tmpC });
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", k+1, cost[N - 1][N - 1]);
        }
    }
}
