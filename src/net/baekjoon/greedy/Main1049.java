package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 1049번 문제 풀이
// 기타줄
public class Main1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] multi = new int[M];
        int[] single = new int[M];

        for(int k=0;k<M;k++) {
            st = new StringTokenizer(br.readLine(), " ");
            multi[k] = Integer.parseInt(st.nextToken());
            single[k] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(multi);
        Arrays.sort(single);

        int set = N / 6;
        int remain = N % 6;
        int min = Integer.MAX_VALUE;

        min = Math.min((set + 1) * multi[0], N * single[0]);
        min = Math.min(min, set * multi[0] + remain * single[0]);
        System.out.println(min);
    }
}
