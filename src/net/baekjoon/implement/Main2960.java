package net.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 2960 에라토스테네스의 체 문제 풀이
public class Main2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        boolean[] filter = new boolean[N + 1];
        for(int k = 2; k <= N; k++){
            for(int l = k; l <= N; l += k){
                if(!filter[l]){
                    cnt += 1;
                    if(cnt == K) {
                        System.out.println(l);
                        break;
                    }
                    filter[l] = true;
                }
            }
        }
    }
}
