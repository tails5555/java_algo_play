package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// SW Expert D4 행렬 찾기 문제 풀이
// 문제 이해하는데 시간 다 허비함 ㅜ 니미럴
public class Main1258 {
    static final int[] dr = { 1, 0 };
    static final int[] dc = { 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for(int l = 0; l < N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int idx = 0;
                while(st.hasMoreTokens()){
                    map[l][idx++] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                int m1 = o1[0] * o1[1];
                int m2 = o2[0] * o2[1];
                if(m1 != m2) return m1 - m2;
                else {
                    return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
                }
            });
            boolean[][] visited = new boolean[N][N];
            for(int l = 0; l < N; l++){
                for(int m = 0; m < N; m++){
                    if(map[l][m] != 0 && !visited[l][m]) {
                        int endR = l;
                        int endC = m;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{ l, m });
                        while(!queue.isEmpty()){
                            int[] tmp = queue.poll();
                            endR = Math.max(tmp[0], endR);
                            endC = Math.max(tmp[1], endC);
                            for(int n = 0; n < dr.length; n++){
                                int tr = tmp[0] + dr[n];
                                int tc = tmp[1] + dc[n];
                                if(tr >= 0 && tr < N && tc >= 0 && tc < N){
                                    if(map[tr][tc] != 0 && !visited[tr][tc]){
                                        visited[tr][tc] = true;
                                        queue.offer(new int[] { tr, tc });
                                    }
                                }
                            }
                        }

                        pq.offer(new int[] { endR - l + 1, endC - m + 1 });
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%d ", pq.size()));
            while(!pq.isEmpty()){
                int[] tmp = pq.poll();
                sb.append(String.format("%d %d ", tmp[0], tmp[1]));
            }

            System.out.printf("#%d %s\n", k+1, sb.toString());
        }
    }
}
