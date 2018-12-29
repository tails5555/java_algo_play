package net.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1748 수 이어 쓰기 1 문제 풀이
public class Main1748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0L;

        int k = 1;
        while(Math.pow(10.0, k) <= N){
            sum += k * (Math.pow(10.0, k) - Math.pow(10.0, k - 1));
            k++;
        }
        if(N <= Math.pow(10.0, k))
            sum += k * (N - Math.pow(10, k - 1) + 1);

        System.out.println(sum);
    }
}
