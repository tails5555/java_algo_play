package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D2 지그재그 숫자 문제
public class Main1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());

            int sum = (N / 2) * (-1);
            sum += (N % 2 == 1) ? N : 0;

            System.out.printf("#%d %d\n", k + 1, sum);
        }
    }
}
