package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// Baekjoon KOI 2014 초등부 전자렌지 문제 풀이
public class Main10162 {
    static final int[] btn = { 300, 60, 10 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        if(T % 10 != 0){
            System.out.println(-1);
        } else {
            int[] cnts = new int[3];
            int tmp = T;
            for (int k = 0; k < btn.length; k++) {
                cnts[k] = tmp / btn[k];
                tmp = tmp % btn[k];
            }

            System.out.println(
                Arrays.stream(cnts)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")
            ));
        }
    }
}
