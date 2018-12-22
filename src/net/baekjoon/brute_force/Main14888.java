package net.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 14888 번 연산자 끼워넣기 문제 풀Yee
public class Main14888 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] values;
    static int N;
    static void calculation(int idx, int plus, int minus, int multi, int div, int val){
        if(idx == N + 1){
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }
        if(plus > 0)
            calculation(idx + 1, plus - 1, minus, multi, div, val + values[idx]);
        if(minus > 0)
            calculation(idx + 1, plus, minus - 1, multi, div, val - values[idx]);
        if(multi > 0)
            calculation(idx + 1, plus, minus, multi - 1, div, val * values[idx]);
        if(div > 0)
            calculation(idx + 1, plus, minus, multi, div - 1, val / values[idx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        values = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int k=1;k<=N;k++){
            values[k] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");

        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int multi = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        calculation(2, plus, minus, multi, div, values[1]);

        System.out.println(max);
        System.out.println(min);
    }
}
