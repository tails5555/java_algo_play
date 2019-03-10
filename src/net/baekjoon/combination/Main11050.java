package net.baekjoon.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 11050 번 이항계수 1 문제 풀이
public class Main11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int from = 1;
        int to = 1;

        for(int k = 0; k < R; k++){
            from *= (N - k);
            to *= (k + 1);
        }

        System.out.println(from / to);
    }
}
