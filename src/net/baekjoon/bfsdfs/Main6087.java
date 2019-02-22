package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 6087 레이저 통신 문제 풀이
public class Main6087 {
    static final int[] dc = { 1, 0, -1, 0 };
    static final int[] dr = { 0, 1, 0, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char[][] map = new char[H][W];
        int[][] c_position = new int[2][4];
        int[][] visit = new int[H][W];
        int cnt = 0;
        for(int k = 0; k < H; k++){
            map[k] = br.readLine().toCharArray();
            for(int l = 0; l < map[k].length; l++){
                if(map[k][l] == 'C'){
                    c_position[cnt][0] = k;
                    c_position[cnt][1] = l;
                    c_position[cnt][2] = -1; // 2번째 값은 레이저가 가고 있는 방향의 인덱스가 주어짐.
                    c_position[cnt][3] = 0; // 3번째 값은 방향 변환의 횟수.
                    cnt += 1;
                }
                visit[k][l] = Integer.MAX_VALUE;
            }
        }

        int result = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        for(int k = 0; k < 4; k++){
            queue.offer(new int[] { c_position[0][0], c_position[0][1], k, 0 });
        }
        visit[c_position[0][0]][c_position[0][1]] = 0;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            if(tmp[0] == c_position[1][0] && tmp[1] == c_position[1][1]){
                result = Math.min(result, tmp[3]);
            }
            for(int k = 0; k < dr.length; k++){
                int tr = dr[k] + tmp[0];
                int tc = dc[k] + tmp[1];
                int next = tmp[3];
                if((tr >= 0 && tr < H) && (tc >= 0 && tc < W)){
                    if(tmp[2] != k)
                        next += 1;
                    if((map[tr][tc] == '.' || map[tr][tc] == 'C') && visit[tr][tc] >= next) {
                        visit[tr][tc] = next;
                        queue.offer(new int[] { tr, tc, k, next });
                    }
                }
            }
        }

        System.out.println(visit[c_position[1][0]][c_position[1][1]]);
    }
}
