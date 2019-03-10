package net.baekjoon.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 11401 번 이항계수 3 문제 풀이
// 페르마의 소정리를 적용해야 쉽게 풀 수 있는 문제.
// nCr = n! / (n - r)! * r! 를 인지해야 한다.
public class Main11401 {
    static final long DIV = 1000000007L;

    static long fast_mul(long x, long y){
        long ans = 1;
        while(y > 0){
            if(y % 2 == 1){
                ans = (ans * x) % DIV;
            }
            x = (x * x) % DIV;
            y /= 2;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long n = 1L;
        long r = 1L;

        for(int k = 2; k <= N; k++){
            n = (n * k) % DIV;
        }

        for(int k = 2; k <= R; k++){
            r = (r * k) % DIV;
        }
        for(int k = 2; k <= (N - R); k++){
            r = (r * k) % DIV;
        }

        r = fast_mul(r, DIV - 2);
        System.out.println((n * r) % DIV);
    }
}
