package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 시각 덧셈 문제 풀이
public class Main1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int sumH = (h1 + h2) % 12 == 0 ? 12 : (h1 + h2) % 12;
            int sumM = m1 + m2;

            if(sumM >= 60) {
                sumH = (sumH + 1 % 12 == 0) ? 12 : (sumH + 1) % 12;
                sumM %= 60;
            }

            System.out.printf("#%d %d %d\n", k+1, sumH, sumM);
        }
    }
}
