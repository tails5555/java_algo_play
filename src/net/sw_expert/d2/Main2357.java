package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D2 September 9 문제 풀이
public class Main2357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            System.out.printf("#%d %s\n", k + 1, (N / 10 == 9 || N % 10 == 9) ? "Yes" : "No");
        }
    }
}
