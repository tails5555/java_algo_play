package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 세제곱근을 찾아라 문제 풀이
public class Main5688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            long N = Long.parseLong(br.readLine());
            if(N == 1L){
                System.out.printf("#%d %d\n", k + 1, 1);
            } else {
                double cube = Math.pow(N, 1.0 / 3.0);
                long round = Math.round(cube);
                if(round * round * round == N) {
                    System.out.printf("#%d %d\n", k + 1, round);
                } else {
                    System.out.printf("#%d -1\n", k + 1);
                }
            }
        }
    }
}
