package net.baekjoon.divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 3079번 문제 입국 심사 풀이
public class Main3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] wait = new long[N];
        for(int k=0;k<N;k++){
            wait[k] = Long.parseLong(br.readLine());
        }

        long start = 1;
        long end = 1000000000000000000L;
        long res = 1000000000000000000L;
        while(start <= end){
            long mid = (start + end) / 2;
            long cnt = 0;
            for(int k=0;k<N;k++){
                cnt += (mid / wait[k]);
            }
            if(cnt >= M){
                if (res > mid) { res = mid; }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(res);
    }
}
