package net.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 4948 베르트랑 공준 문제 풀이
public class Main4948 {
    static final int LIMIT = 123456 * 2;
    public static void main(String[] args) throws IOException {
        boolean[] isNotPrime = new boolean[LIMIT + 1];
        isNotPrime[1] = true;
        for(int k = 2; k <= LIMIT; k++){
            for(int l = k * 2; l <= LIMIT; l += k){
                isNotPrime[l] = true;
            }
        }

        int[] primeCnt = new int[LIMIT + 1];
        primeCnt[2] = 1;
        int tmpPrime = 2;
        for(int k = 3; k <= LIMIT; k++){
            if(!isNotPrime[k]) {
                primeCnt[k] = primeCnt[tmpPrime] + 1;
                tmpPrime = k;
            } else {
                primeCnt[k] = primeCnt[k - 1];
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            System.out.println(primeCnt[N * 2] - primeCnt[N]);
        }
    }
}
