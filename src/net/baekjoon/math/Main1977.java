package net.baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1977 번 완전제곱수 문제 풀이
public class Main1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int from = Integer.parseInt(br.readLine());
        int to = Integer.parseInt(br.readLine());

        int startLog = (int) Math.ceil(Math.sqrt(from));
        int endLog = (int) Math.floor(Math.sqrt(to));

        if(startLog > endLog){
            System.out.println(-1);
        } else {
            int sum = 0;
            for(int k = startLog; k <= endLog; k++){
                sum += (k * k);
            }
            System.out.println(sum);
            System.out.println(startLog * startLog);
        }
    }
}
