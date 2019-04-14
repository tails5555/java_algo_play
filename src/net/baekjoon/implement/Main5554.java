package net.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 5554 심부름 가는 길 문제 풀이
public class Main5554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int f1 = Integer.parseInt(br.readLine());
        int f2 = Integer.parseInt(br.readLine());
        int f3 = Integer.parseInt(br.readLine());
        int f4 = Integer.parseInt(br.readLine());

        int sum = f1 + f2 + f3 + f4;

        System.out.println(sum / 60);
        System.out.println(sum % 60);
    }
}
