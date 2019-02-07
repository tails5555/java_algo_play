package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 삼성 SW Expert D1 알파벳을 숫자로 변환 문제 풀이
public class Main2050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        for(char c : str){
            sb.append(String.format("%d ", c - 'A' + 1));
        }
        System.out.println(sb.toString());
    }
}
