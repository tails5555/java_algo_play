package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon KOI 2016 초등부 타일 장식물 문제 풀이
public class Main13301 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] edge = new long[N + 1];
        edge[0] = 1L;
        edge[1] = 1L;
        for(int k = 2; k <= N; k++){
            edge[k] = edge[k - 1] + edge[k - 2];
        }

        System.out.println((edge[N] + edge[N - 1]) * 2L);
    }
}
