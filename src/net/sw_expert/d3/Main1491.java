package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 우원재의 벽 꾸미기 문제
public class Main1491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            long N = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long ans = Long.MAX_VALUE;
            for(long l = 1; l <= N / 2; l++){
                for(long m = l; m * l <= N; m++){
                    ans = Math.min(ans, A * Math.abs(l - m) + B * (N - m * l));
                }
            }

            System.out.printf("#%d %d\n", k+1, ans);
        }
    }
}
