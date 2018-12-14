package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] coin = { 500, 100, 50, 10, 5, 1 };
        int taro = 1000 - Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int k=0;k<coin.length;k++){
            cnt += taro / coin[k];
            taro %= coin[k];
        }
        System.out.println(cnt);
    }
}
