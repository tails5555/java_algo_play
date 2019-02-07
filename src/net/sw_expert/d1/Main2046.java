package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 삼성 SW Expert D1 스템프 찍기 풀이
public class Main2046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<N;k++){
            sb.append("#");
        }
        System.out.println(sb.toString());
    }
}
