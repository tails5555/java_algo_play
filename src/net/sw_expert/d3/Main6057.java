package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 그래프의 삼각형 문제 풀이
public class Main6057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[N+1][N+1];
            int cnt = 0;
            for(int l = 0; l < M; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = map[to][from] = true;
            }

            for(int a = 1; a <= N; a++){
                for(int b = a + 1; b <= N; b++){
                    for(int c = b + 1; c <= N; c++){
                        if(map[a][b] && map[b][c] && map[a][c])
                            cnt += 1;
                    }
                }
            }

            System.out.printf("#%d %d\n", k + 1, cnt);
        }
    }
}
