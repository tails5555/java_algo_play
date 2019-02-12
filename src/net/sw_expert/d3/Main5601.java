package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 쥬스 나누기 문제 풀이
public class Main5601 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int l = 0; l < N; l++){
                if(l != N - 1)
                    sb.append(String.format("1/%d ", N));
                else
                    sb.append(String.format("1/%d\n", N));
            }
            System.out.printf("#%d %s", k+1, sb.toString());
        }
    }
}
