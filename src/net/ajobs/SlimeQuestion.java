package net.ajobs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 알고리슴 잡스 S기업 기출 유사 문제 심심풀이
public class SlimeQuestion {
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };

    public static boolean validate(int[][] map, int from, int to){
        for(int k=0;k<map.length;k++){
            for(int l=0;l<map[k].length;l++){
                int tmp = map[k][l];
                for(int m=0;m<dx.length;m++){
                    int ty = dy[m] + k;
                    int tx = dx[m] + l;
                    if((ty >= 0 && ty < map.length) && (tx >= 0 && tx < map.length)){
                        int dist = Math.abs(tmp - map[ty][tx]);
                        if(dist >= from && dist <= to) return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for(int k=0;k<N;k++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int l=0;l<N;l++){
                map[k][l] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        if(N > 1) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];

            queue.offer(new int[]{0, 0});
            visited[0][0] = true;
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                int tmp1 = map[pos[0]][pos[1]];

                List<int[]> divider = new ArrayList<>();
                divider.add(new int[]{pos[0], pos[1]});
                for (int k = 0; k < dy.length; k++) {
                    int ty = dy[k] + pos[0];
                    int tx = dx[k] + pos[1];
                    if ((ty >= 0 && ty < N) && (tx >= 0 && tx < N)) {
                        int tmp2 = map[ty][tx];
                        int dist = Math.abs(tmp1 - tmp2);
                        if ((dist >= from && dist <= to) && !visited[ty][tx]) {
                            queue.offer(new int[]{ty, tx});
                            divider.add(new int[]{ty, tx});
                            visited[ty][tx] = true;
                        }
                    }
                }

                if (divider.size() > 1) {
                    int avg = divider.stream().map(idx -> map[idx[0]][idx[1]]).reduce(0, (i1, i2) -> i1 + i2) / divider.size();
                    for (int[] idx : divider) {
                        map[idx[0]][idx[1]] = avg;
                    }
                    cnt += 1;
                }

                if (!validate(map, from, to)) break;
            }
        }

        System.out.println(cnt);
    }
}
