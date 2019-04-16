package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Baekjoon 2236번 KOI 2000년 초등부 3번 치즈 문제 풀이
// 생각보다 응용을 요구하는 문제가 있었음. (바로 이전 값을 가져오는 거)
public class Main2236 {
    static final int[] dr = new int[] { -1, 1,  0, 0 };
    static final int[] dc = new int[] {  0, 0, -1, 1 };
    static int R, C;
    static int[][] map;

    static void outside_air(int r, int c){
        if(r < 0 || r > R - 1 || c < 0 || c > C - 1) return;
        if(map[r][c] > 0) return;
        map[r][c] = 2;
        for(int k = 0; k < dr.length; k++){
            outside_air(r + dr[k], c + dc[k]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int r = 0; r < R; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(true){
            int cnt = 0;
            for(int r = 0; r < R; r++){
                for(int c = 0; c < C; c++){
                    cnt += (map[r][c] == 1) ? 1 : 0;
                }
            }

            if(cnt > 0) {
                pq.offer(cnt);
                time += 1;
                outside_air(0, 0);

                int[][] temp = new int[R][C];
                for (int r = 1; r < R - 1; r++) {
                    for (int c = 1; c < C - 1; c++) {
                        if (map[r][c] == 1) {
                            int count = 0;
                            count += (map[r - 1][c] == 2) ? 1 : 0;
                            count += (map[r + 1][c] == 2) ? 1 : 0;
                            count += (map[r][c - 1] == 2) ? 1 : 0;
                            count += (map[r][c + 1] == 2) ? 1 : 0;
                            if (count >= 1) temp[r][c] = 0;
                            else temp[r][c] = 1;
                        } else temp[r][c] = 0;
                    }
                }

                for(int k = 0; k < R; k++){
                    for(int l = 0; l < C; l++){
                        map[k][l] = temp[k][l];
                    }
                }
            } else {
                System.out.println(time);
                System.out.println(pq.poll());
                break;
            }
        }
    }
}
