package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 2436 번 KOI 2011 초등부 공약수 문제 풀이
public class Main2436 {
    static int gcd(int p, int q) {
        if(q == 0) return p;
        return gcd(q, p % q);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int gcd = Integer.parseInt(st.nextToken());
        int lcm = Integer.parseInt(st.nextToken());

        int com = lcm / gcd;

        int left = 0, right = 0;
        for(int k = 1; k <= Math.sqrt(com); k++){
            if(com % k == 0) {
                if(gcd(k, com / k) == 1) {
                    left = k;
                    right = com / k;
                }
            }
        }

        System.out.println((left * gcd) + " " + (right * gcd));
    }
}

// A = a / GCD
// B = b / GCD
// LCM = a * b * GCD, a 와 b 는 서로소
// 즉, 서로소(최대공약수가 1인 경우) 를 잘 찾으면 금방 푸는 문제였음.