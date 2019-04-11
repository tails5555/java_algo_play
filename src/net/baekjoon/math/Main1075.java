package net.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1075 번 나누기 문제 풀이
public class Main1075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int front = N / 100;
        for(int k = 0; k <= 99; k++){
            int t = front * 100 + k;
            if(t % K == 0) {
                System.out.printf("%02d\n", k);
                break;
            }
        }
    }
}
