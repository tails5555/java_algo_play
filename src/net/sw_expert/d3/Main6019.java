package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 기차 사이의 파리 문제 풀이
// 중학교 물리 시간에 안 쳐 잤으면 그냥 풀 수 있는 간단한 문제
public class Main6019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int D, A, B, F;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            D = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());

            double total_time = (double) D / (A + B);
            System.out.printf("#%d %f\n", k+1, total_time * F);
        }
    }
}
