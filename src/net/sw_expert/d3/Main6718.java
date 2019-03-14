package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 희성이의 원근법 문제 풀이
public class Main6718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int t = Integer.parseInt(br.readLine());
            if(t < 100) {
                System.out.printf("#%d %d\n", k + 1, 0);
            } else if(t >= 100 && t < 1000) {
                System.out.printf("#%d %d\n", k + 1, 1);
            } else if(t >= 1000 && t < 10000) {
                System.out.printf("#%d %d\n", k + 1, 2);
            } else if(t >= 10000 && t < 100000) {
                System.out.printf("#%d %d\n", k + 1, 3);
            } else if(t >= 100000 && t < 1000000) {
                System.out.printf("#%d %d\n", k + 1, 4);
            } else {
                System.out.printf("#%d %d\n", k + 1, 5);
            }
        }
    }
}
