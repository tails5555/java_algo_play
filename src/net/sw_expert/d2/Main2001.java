package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 파리 퇴치 문제 풀이
public class Main2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            int res = Integer.MIN_VALUE;
            for(int l = 0; l < N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int idx = 0;
                while(st.hasMoreTokens()) {
                    map[l][idx++] = Integer.parseInt(st.nextToken());
                }
                if((l + 1) - M >= 0) {
                    for(int m = 0; m <= N - M; m++){
                        int sum = 0;
                        for(int a = m; a < m + M; a++) {
                            for (int b = (l + 1) - M; b <= l; b++) {
                                sum += map[b][a];
                            }
                        }
                        res = Math.max(res, sum);
                    }
                }
            }
            System.out.printf("#%d %d\n", k+1, res);
        }
    }
}
