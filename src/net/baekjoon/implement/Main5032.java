package net.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 5032 탄산음료 문제 풀이
// 등비수열 개념을 약간 생각해야 하는 문제. 쉬운 문제였지만, 수리적인 논리가 필요함.
public class Main5032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int have = Integer.parseInt(st.nextToken());
        int now = Integer.parseInt(st.nextToken());
        int change = Integer.parseInt(st.nextToken());

        int current = have + now;
        int drink = 0;
        while(current >= change) {
            drink += (current / change);
            current = (current % change) + (current / change);
        }

        System.out.println(drink);
    }
}
