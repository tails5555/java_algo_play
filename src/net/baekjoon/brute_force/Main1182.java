package net.baekjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 1182 번 부분 집합의 수 풀이
public class Main1182 {
    static int N;
    static int S;
    static int result = 0;
    static int[] set;
    public static void solution(int idx, int sum){
        if(idx >= N) return;
        sum += set[idx];
        if(sum == S) result++;
        solution(idx + 1, sum - set[idx]);
        solution(idx + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        set = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while(st.hasMoreTokens()){
            set[idx++] = Integer.parseInt(st.nextToken());
        }
        solution(0, 0);

        System.out.println(result);
    }
}
