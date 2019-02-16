package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 정삼각형 분할
public class Main3233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken()) ;

            long c = a / b;
            long res = c * c;
            System.out.printf("#%d %d\n", k+1, res);
        }
    }
}
