package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SW Expert D4 사다리 게임 1 문제 풀이
public class Main1210 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int k = 0; k < 10; k++) {
            int test = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];
            for(int l = 0; l < 100; l++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int m = 0; m < 100; m++){
                    map[l][m] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<int[]> queue;
            boolean[][] visited;
            int answer = -1;
            for(int l = 0; l < 100; l++){
                if(map[0][l] == 1) {
                    queue = new LinkedList<>();
                    visited = new boolean[100][100];

                    queue.offer(new int[] { 0, l });
                    visited[0][l] = true;

                    while(!queue.isEmpty()){
                        int[] tmp = queue.poll();
                        int tr = tmp[0];
                        int tc = tmp[1];

                        if(tr == 99){
                            if(map[tr][tc] == 2)
                                answer = l;
                            break;
                        } else {
                            int left = tc - 1;
                            int right = tc + 1;
                            int down = tr + 1;

                            if (left >= 0 && left <= 99) {
                                if (map[tr][left] == 1 && !visited[tr][left]) {
                                    queue.offer(new int[]{tr, left});
                                    visited[tr][left] = true;
                                    continue;
                                }
                            }

                            if (right >= 0 && right <= 99) {
                                if (map[tr][right] == 1 && !visited[tr][right]) {
                                    queue.offer(new int[]{tr, right});
                                    visited[tr][right] = true;
                                    continue;
                                }
                            }

                            if (down >= 0 && down <= 99) {
                                if (map[down][tc] >= 1 && !visited[down][tc]) {
                                    queue.offer(new int[]{down, tc});
                                    visited[down][tc] = true;
                                    continue;
                                }
                            }
                        }
                    }
                }

                if(answer != -1) break;
            }

            System.out.printf("#%d %d\n", test, answer);
        }
    }
}
