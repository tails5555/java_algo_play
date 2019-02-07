package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 삼성 SW Expert D1 자릿수 합치기 문제
public class Main2058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();

        int tmp = 0;
        for(char c : str){
            tmp += (c - '0');
        }
        System.out.println(tmp);
    }
}
