package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Baekjoon 2217 번 문제
// 로프 문제
public class Main2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] rope = new int[N];
        for(int k=0;k<N;k++){
            rope[k] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        int idx = N - 1;
        int max = Integer.MIN_VALUE;
        while(idx >= 0){
            max = Math.max(max, rope[idx] * (N - idx));
            idx--;
        }
        System.out.println(max);
    }
}
