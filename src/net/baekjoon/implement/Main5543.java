package net.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 5543 란란루 문제 풀이
public class Main5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] burger = new int[3];
        for(int k = 0; k < 3; k++){
            burger[k] = Integer.parseInt(br.readLine());
        }

        int[] drink = new int[2];
        for(int k = 0; k < 2; k++){
            drink[k] = Integer.parseInt(br.readLine());
        }

        int sum = Integer.MAX_VALUE;
        for(int k = 0; k < 3; k++){
            for(int l = 0; l < 2; l++){
                sum = Math.min(burger[k] + drink[l] - 50, sum);
            }
        }

        System.out.println(sum);
    }
}
