package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 가랏! RC카 문제
public class Main1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            int N = Integer.parseInt(br.readLine());
            int v = 0;
            int dist = 0;
            for(int l=0;l<N;l++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int c = Integer.parseInt(st.nextToken());
                if(c != 0) {
                    if(c == 1) {
                        v += Integer.parseInt(st.nextToken());
                    } else {
                        v -= Integer.parseInt(st.nextToken());
                        if(v < 0) v = 0;
                    }
                }
                dist += v;
            }
            System.out.printf("#%d %d\n", k+1, dist);
        }
    }
}
