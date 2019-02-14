package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 다슬이의 월급 상자 문제 풀이
public class Main6692 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            double sum = 0.0f;
            for(int l = 0; l < N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                sum += Double.parseDouble(st.nextToken()) * Double.parseDouble(st.nextToken());
            }

            System.out.printf("#%d %.6f\n", k+1, sum);
        }
    }
}
