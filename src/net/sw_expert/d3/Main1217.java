package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 거듭 제곱 문제 풀이
public class Main1217 {
    static int power(int N, int x) {
        if(x == 0) return 1;
        else return N * power(N, x - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k=0;k<10;k++){
            int T = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            System.out.printf("#%d %d\n", T, power(n, x));
        }
    }
}
