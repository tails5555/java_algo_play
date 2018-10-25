package net.baekjoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1026번 문제 풀이
public class Main1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int k=0;k<N;k++){
            a[k] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int k=0;k<N;k++){
            b[k] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);
        int result = 0;
        for(int k=0;k<N;k++){
            result += a[k] * b[N - 1 - k];
        }
        System.out.println(result);
    }
}
