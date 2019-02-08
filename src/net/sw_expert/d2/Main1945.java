package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D2 간단한 소인수분해 문제 풀이
public class Main1945 {
    static final int[] element = { 2, 3, 5, 7, 11 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[element.length];
            for(int l=0;l<arr.length;l++){
                while(N % element[l] == 0) {
                    arr[l] += 1;
                    N /= element[l];
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int a : arr){
                sb.append(String.format("%d ", a));
            }
            System.out.printf("#%d %s\n", k+1, sb.toString());
        }
    }
}
