package net.baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 9251. LCS 문제 풀이
public class Main9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        char[] word1 = s1.toCharArray();
        char[] word2 = s2.toCharArray();
        int[][] dp = new int[word1.length > word2.length ? word1.length : word2.length][26];
        for(int k=0;k<word1.length;k++){
            for(int l=0;l<word2.length;l++){

            }
        }
    }
}
