package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 대회 or 인턴 문제 풀이
public class Main2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int team = Integer.MIN_VALUE;

        for (int k = 0; k <= K; k++) {
            int remain = K - k;
            team = Math.max(team, Math.min((N - k) / 2, M - remain));
        }

        System.out.println(team);
    }
}