package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 1138번 한 줄 서기 문제 풀이
public class Main1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] line = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = 1;
        while(st.hasMoreTokens()){
            int pivot = Integer.parseInt(st.nextToken());
            for(int k = 0; k < N; k++){
                if(pivot == 0 && line[k] == 0) {
                    line[k] = n;
                    break;
                } else if(line[k] == 0) {
                    pivot -= 1;
                }
            }
            n += 1;
        }

        for(int k : line) {
            System.out.printf("%d ", k);
        }
    }
}
