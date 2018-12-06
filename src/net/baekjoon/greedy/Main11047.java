package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 11047번 문제 풀이
public class Main11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] coin = new int[Integer.parseInt(st.nextToken()) + 1];
        int money = Integer.parseInt(st.nextToken());
        for(int k=1;k<coin.length;k++){
            coin[k] = Integer.parseInt(br.readLine());
        }
        int idx = coin.length - 1;
        int rest = money;
        int count = 0;
        while(idx >= 1){
            count += rest / coin[idx];
            rest %= coin[idx];
            idx--;
        }
        System.out.println(count);
    }
}
