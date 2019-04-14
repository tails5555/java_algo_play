package net.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 2851 슈퍼마리오 문제 풀이
public class Main2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        int diff = 100;
        int res = 0;
        for(int k = 0; k < 10; k++){
            score += Integer.parseInt(br.readLine());
            if(Math.abs(100 - score) < diff){
                res = score;
                diff = Math.abs(100 - score);
            }
            else if(Math.abs(100 - score) == diff){
                res = Math.max(score, res);
            }
        }

        System.out.println(res);
    }
}
