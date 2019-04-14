package net.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 2935 소음 문제 풀이
// 원래 BigInteger 를 사용하면 꿀인데, 이를 안 사용해서 풀어보는 연습을 진행해보자.
public class Main2935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String oper = br.readLine();
        String b = br.readLine();

        int a_zero = a.length() - 1;
        int b_zero = b.length() - 1; // 어자피 10의 제곱이면 0의 개수는 (자리 수 - 1) 이다.

        StringBuilder sb = new StringBuilder();
        if(oper.equals("+")){
            if(a_zero == b_zero) {
                sb.append(2);
                for(int k = 0; k < a_zero; k++){
                    sb.append(0);
                }
                System.out.println(sb.toString());
            } else {
                int max = Math.max(a_zero, b_zero);
                int min = Math.min(a_zero, b_zero);
                sb.append(1);
                for(int k = 0; k < max - (min + 1); k++){
                    sb.append(0);
                }
                sb.append(1);
                for(int k = 0; k < min; k++){
                    sb.append(0);
                }
                System.out.println(sb.toString());
            }
        } else {
            sb.append(1);
            for(int k = 0; k < a_zero + b_zero; k++){
                sb.append(0);
            }
            System.out.println(sb.toString());
        }
    }
}
