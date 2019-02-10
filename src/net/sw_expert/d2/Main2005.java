package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D2 파스칼의 삼각형 문제 풀이
public class Main2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int[][] pascal = new int[N][N];
            pascal[0][0] = 1;
            if(N > 1) {
                pascal[1][0] = pascal[1][1] = 1;

                if(N > 2) {
                    for(int l = 2; l < N; l++){
                        for(int m = 0; m <= l; m++){
                            if(m == 0 || m == l) pascal[l][m] = 1;
                            else pascal[l][m] = pascal[l - 1][m - 1] + pascal[l - 1][m];
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int l = 0; l < N; l++){
                for(int m = 0; m <= l; m++){
                    sb.append(String.format("%d ", pascal[l][m]));
                }
                if(l != N - 1)
                    sb.append("\n");
            }
            System.out.printf("#%d\n", k+1);
            System.out.println(sb.toString());
        }
    }
}
