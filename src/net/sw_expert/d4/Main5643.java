package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// SW Expert D4 키 순서 문제 풀이
public class Main5643 {
    static final int MAX = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int[][] floyd = new int[N + 1][N + 1];
            for(int l = 1; l <= N; l++){
                Arrays.fill(floyd[l], MAX);
                floyd[l][l] = 0;
            }
            for(int m = 0; m < M; m++){
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                floyd[from][to] = 1;
            }

            for(int m = 1; m <= N; m++){
                for(int a = 1; a <= N; a++){
                    for(int b = 1; b <= N; b++){
                        if(a == b || b == m || a == m) continue;
                        floyd[a][b] = Math.min(floyd[a][b], floyd[a][m] + floyd[m][b]);
                    }
                }
            }

            int res = 0;
            for(int l = 1; l <= N; l++){
                boolean checked = true;
                for(int m = 1; m <= N; m++){
                    if(floyd[l][m] == MAX && floyd[m][l] == MAX) {
                        checked = false;
                        break;
                    }
                }
                if(checked) res += 1;
            }

            System.out.printf("#%d %d\n", k + 1, res);
        }
    }
}
