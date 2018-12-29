package net.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 2331번 분해합 문제 풀이
public class Main2231 {
    static boolean sumFinder(int target, int value){
        int sum = 0;
        String tmp = Integer.toString(value);
        for(char c : tmp.toCharArray()) {
            sum += c - '0';
        }
        return target == sum + value;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int value = 0;
        for(int k=1;k<=N;k++){
            if(sumFinder(N, k)) {
                value = k;
                break;
            }
        }
        System.out.println(value);
    }
}
