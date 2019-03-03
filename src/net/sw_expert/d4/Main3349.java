package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 최솟값으로 이동하기 문제 풀이
public class Main3349 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[][] list = new int[N][2];
            for (int l = 0; l < N; l++) {
                st = new StringTokenizer(br.readLine(), " ");
                list[l][1] = Integer.parseInt(st.nextToken());
                list[l][0] = Integer.parseInt(st.nextToken());
            }

            if (N > 0) {
                int walk = 0;
                for (int l = 1; l < N; l++) {
                    int dr = list[l][0] - list[l - 1][0];
                    int dc = list[l][1] - list[l - 1][1];

                    if ((dr > 0 && dc > 0) || (dr < 0 && dc < 0)) {
                        int cross = (dr > 0) ? Math.min(dr, dc) : Math.min(Math.abs(dr), Math.abs(dc));
                        if (dr > 0) {
                            walk += (cross + ((dr > dc) ? dr - cross : dc - cross));
                        } else {
                            walk += (cross + (Math.abs(dr) > Math.abs(dc) ? Math.abs(dr) - cross : Math.abs(dc) - cross));
                        }
                    } else {
                        walk += (Math.abs(dr) + Math.abs(dc));
                    }
                }

                System.out.printf("#%d %d\n", k + 1, walk);
            } else {
                System.out.printf("#%d %d\n", k + 1, 0);
            }
        }
    }
}
