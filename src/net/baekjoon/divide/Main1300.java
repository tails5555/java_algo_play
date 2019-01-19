package net.baekjoon.divide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1300번 K번째 수 문제 풀이
// 무슨 의미인지 감이 안 잡힌다. 복습 필요.
public class Main1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());


        int left = 1;
        int right = k;
        while(left <= right) {
            int mid = (left + right) / 2;
            long cnt = 0;
            for(int a=1;a<=N;a++){
                cnt += Math.min(mid / a, N);
            }

            if((int) cnt < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(left);
    }
}
