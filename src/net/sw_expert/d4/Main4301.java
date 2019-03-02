package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 콩진호 많이 심기
public class Main4301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[R][C];
            int res = R * C;
            for(int r = 0; r < R; r++){
                for(int c = 0; c < C; c++){
                    if(!map[r][c]) {
                        int tr = r + 2;
                        if (tr >= 0 && tr < R) {
                            if (!map[tr][c]) {
                                map[tr][c] = true;
                                res -= 1;
                            }
                        }

                        int tc = c + 2;
                        if (tc >= 0 && tc < C) {
                            if (!map[r][tc]) {
                                map[r][tc] = true;
                                res -= 1;
                            }
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", k+1, res);
        }
    }
}