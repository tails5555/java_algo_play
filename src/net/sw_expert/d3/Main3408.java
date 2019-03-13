package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 세가지 합 구하기 문제 풀이
// 1~N 까지 합은 (N + 1) * N / 2
// 1, 3, ... , 2N - 1 까지 합은 N * N
// 2, 4, ... , 2N 까지 합은 N * N + 1
// 이를 응용하는 문제였음. 수학 개념 관련해서 알아두면 좋은 문제 :)
public class Main3408 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            long N = Long.parseLong(br.readLine());
            System.out.printf("#%d %d %d %d\n", k + 1, N * (N + 1) / 2, N * N, N * N + N);
        }
    }
}
