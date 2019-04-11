package net.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1964 번 오각형 문제 풀이
public class Main1964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long start = 5;
        for(long k = 2; k <= N; k++){
            start = (start + (k + 1) + k * 2) % 45678L;
        }
        System.out.println(start);
    }
}
