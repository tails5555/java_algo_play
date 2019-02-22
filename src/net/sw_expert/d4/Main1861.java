package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// SW Expert D4 정사각형의 방 문제 풀이
public class Main1861 {
    static final int[] dr = { 1, 0, -1, 0 };
    static final int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
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
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                } else return o2[1] - o1[1];
            });

            for(int l = 0; l < N; l++){
                for(int m = 0; m < N; m++){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[] { l, m, 1 });
                    int tmpRes = Integer.MIN_VALUE;
                    while(!queue.isEmpty()){
                        int[] cur = queue.poll();
                        tmpRes = Math.max(tmpRes, cur[2]);
                        int curV = map[cur[0]][cur[1]];
                        for(int n = 0; n < dr.length; n++){
                            int tr = cur[0] + dr[n];
                            int tc = cur[1] + dc[n];
                            if(tr >= 0 && tr < N && tc >= 0 && tc < N){
                                int nextV = map[tr][tc];
                                if(curV + 1 == nextV){
                                    queue.offer(new int[] { tr, tc, cur[2] + 1 });
                                }
                            }
                        }
                    }

                    pq.offer(new int[] { map[l][m], tmpRes });
                }
            }

            int[] res = pq.poll();
            System.out.printf("#%d %d %d\n", k+1, res[0], res[1]);
        }
    }
}
