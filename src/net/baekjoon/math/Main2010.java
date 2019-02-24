package net.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 2010 번 플러그 문제 풀이
public class Main2010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int k = 0; k < N - 1; k++){
            int tmp = Integer.parseInt(br.readLine());
            sum += (tmp - 1);
        }

        int last = Integer.parseInt(br.readLine());
        System.out.println(sum + last);
    }
}
