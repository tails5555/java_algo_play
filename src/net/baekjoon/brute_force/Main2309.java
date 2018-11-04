package net.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// Baekjoon 2309 번 문제 풀이
public class Main2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] boys = new int[10];
        int idx = 1;
        while(idx < 10){
            boys[idx++] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(boys);
        int expA = -1;
        int expB = -1;
        for(int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                if(a != b){
                    int sum = 0;
                    for(int c = 1; c <= 9; c++){
                        if(a != c && b != c){
                            sum += boys[c];
                        }
                    }
                    if(sum == 100){
                        expA = a;
                        expB = b;
                        break;
                    }
                }
            }
            if(expA != -1) break;
        }
        for(int k=1;k<=9;k++){
            if(k != expA && k != expB){
                System.out.println(boys[k]);
            }
        }
    }
}
