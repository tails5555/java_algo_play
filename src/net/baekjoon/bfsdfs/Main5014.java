package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 5014 번 문제 스타트링크 문제 풀이
public class Main5014 {
    static final int MAX = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int res = MAX;

        boolean[] visited = new boolean[F + 1];
        Queue<int[]> queue = new LinkedList<>();

        visited[S] = true;
        queue.add(new int[] { S, 0 });
        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if(tmp[0] == G) {
                res = Math.min(res, tmp[1]);
                break;
            }

            int up = tmp[0] + U;
            int down = tmp[0] - D;

            if(up <= F) {
                if(!visited[up]) {
                    visited[up] = true;
                    queue.offer(new int[] { up, tmp[1] + 1 });
                }
            }

            if(down > 0) {
                if(!visited[down]) {
                    visited[down] = true;
                    queue.offer(new int[] { down, tmp[1] + 1 });
                }
            }
        }

        System.out.println(res == MAX ? "use the stairs" : res);
    }
}
