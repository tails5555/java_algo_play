package net.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1300. K 번째 수 문제 풀이
// 이진 탐색은 좀 공부해야 될 듯함...
public class Main1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int start = 1;
        int end = K;
        int answer = 0;
        while(start <= end){
            int mid = (start + end) / 2;
            long sum = 0L;
            for(int k=1;k<=N;k++){
                sum += Math.min(N, mid / k);
            }
            if(K <= sum){
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
