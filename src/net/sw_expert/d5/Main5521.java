package net.sw_expert.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SW Expert D5 상원이의 생일빠리 문제 풀이
public class Main5521 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[N + 1][N + 1];

            for(int l = 0; l < M; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = map[to][from] = true;
            }

            int cnt = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] { 1, 0 });
            boolean[] visited = new boolean[N + 1];
            visited[1] = true;
            while(!queue.isEmpty()){
                int[] tmp = queue.poll();
                for(int l = 1; l <= N; l++){
                    if(!visited[l] && map[tmp[0]][l]) {
                        if(tmp[1] >= 0 && tmp[1] <= 1) {
                            cnt += 1;
                            queue.offer(new int[] { l, tmp[1] + 1 });
                            visited[l] = true;
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", k + 1, cnt);
        }
    }
}
