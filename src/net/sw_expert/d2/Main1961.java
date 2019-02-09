package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 숫자 배열 회전 문제 풀이
public class Main1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T ; k++) {
            int N = Integer.parseInt(br.readLine());
            int[][] tmp = new int[N][N];
            StringBuilder[] sbs = new StringBuilder[N];
            for(int l = 0; l < N; l++){
                sbs[l] = new StringBuilder();
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int idx = 0;
                while(st.hasMoreTokens()) {
                    tmp[l][idx++] = Integer.parseInt(st.nextToken());
                }
            }

            for(int l = 0; l < 3; l++){
                int[][] rotation = new int[N][N];
                int rIdx = -1;
                int cIdx;
                for(int m = 0; m < N; m++){
                    rIdx += 1;
                    cIdx = 0;
                    for(int n = N - 1; n >= 0; n--){
                        rotation[rIdx][cIdx++] = tmp[n][m];
                        sbs[rIdx].append(String.format("%d", tmp[n][m]));
                    }
                    if(l != 2)
                        sbs[rIdx].append(" ");
                }

                tmp = rotation;
            }

            System.out.printf("#%d\n", k + 1);
            for(StringBuilder sb : sbs){
                System.out.println(sb.toString());
            }
        }
    }
}
