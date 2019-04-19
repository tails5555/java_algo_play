package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon KOI 2005 초등부 본선 2번 곱셈 문제 풀이
public class Main2588 {
    static BufferedReader br;
    static int n1, n2;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n1 = Integer.parseInt(br.readLine());
        n2 = Integer.parseInt(br.readLine());
    }

    static void solution() {
        System.out.println(n1 * (n2 % 10));
        System.out.println(n1 * ((n2 / 10) % 10));
        System.out.println(n1 * (n2 / 100));
        System.out.println(n1 * n2);
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}
