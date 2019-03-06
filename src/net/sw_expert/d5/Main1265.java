package net.sw_expert.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D5 달란트2 문제 풀이
public class Main1265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            long div = N / K;
            long mod = N % K;

            long max = 1L;
            for(long l = 0; l < K - mod; l++){
                max *= div;
            }
            for(long l = 0; l < mod; l++) {
                max *= (div + 1);
            }
            System.out.printf("#%d %d\n", k + 1, max);
        }
    }
}
