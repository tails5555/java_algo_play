package net.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

// Baekjoon 5597 과제 안 한 새끼 문제 풀이
public class Main5597 {
    public static void main(String[] args) throws IOException {
        Set<Integer> set = new TreeSet<>();
        for(int k = 1; k <= 30; k++){
            set.add(k);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k = 0; k < 28; k++){
            int cur = Integer.parseInt(br.readLine());
            set.remove(cur);
        }
        for(int k : set){
            System.out.println(k);
        }
    }
}
