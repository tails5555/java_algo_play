package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 건초더미 문제 풀이
public class Main5603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            int[] weeds = new int[N];
            int sum = 0;
            for(int l = 0; l < N; l++) {
                weeds[l] = Integer.parseInt(br.readLine());
                sum += weeds[l];
            }
            int res = 0;
            for(int l = 0; l < N; l++){
                if(sum / N < weeds[l])
                    res += (weeds[l] - sum / N);
            }
            System.out.printf("#%d %d\n", k+1, res);
        }
    }
}
