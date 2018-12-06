package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int k=1;k<=N;k++){
            time[k] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time);
        int result = 0;
        int bonus = 0;
        for(int k=1;k<=N;k++){
            result = result + bonus + time[k];
            bonus += time[k];
        }
        System.out.println(result);
    }
}
