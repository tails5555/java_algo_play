package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D2 쉬운 거스름돈 문제 풀이
public class Main1970 {
    static int[] bill = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int[] res = new int[8];
            for(int l=0;l<8;l++){
                res[l] = N / bill[l];
                N = N % bill[l];
            }
            StringBuilder sb = new StringBuilder();
            for(int a : res){
                sb.append(String.format("%d ", a));
            }
            System.out.printf("#%d\n", k+1);
            System.out.println(sb.toString());
        }
    }
}
