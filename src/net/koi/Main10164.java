package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon KOI 2014 초등부 격자상의 경로 문제 풀이
public class Main10164 {
    static long factorial(int x) {
        if(x <= 1) return 1;
        else return x * factorial(x - 1);
    }

    static long dist(int n, int m){
        long t = (n + m);
        long tmp = 1;
        for(long k = t; k > Math.max(n, m); k--){
            tmp *= k;
        }
        return tmp / factorial(Math.min(n, m));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(K == 0) {
            System.out.println(dist(N - 1, M - 1));
        } else {
            int tr = (int) Math.ceil((double) K / M);
            int tc = (K % M == 0) ? M : K % M;

            long from = dist(tr - 1, tc - 1);
            long to = dist(N - tr, M - tc);
            System.out.println(from * to);
        }
    }
}

// 1. DP 를 사용한 접근 방법 O(N * M)
// 2. 공식을 이용한 접근 방법 O(N + M)
// 가로 N, 세로 M 의 이동 경로는? (N + M)! / N! * M!
// 가로와 세로 중 가장 큰 값을 맨 처음에 없애주고, 이외의 팩토리얼로 나뉘어줌. 단 이는 long 데이터를 사용해야 함.