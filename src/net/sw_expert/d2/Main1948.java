package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 날짜 계산기 문제 풀이
public class Main1948 {
    static final int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());
            if(m1 == m2) {
                System.out.printf("#%d %d", k+1, d2 - d1 + 1);
            } else {
                int day = 0;
                for(int l = m1; l <= m2;l++){
                    if(l == m1) {
                        day += (days[l] - d1 + 1);
                    } else if(l == m2) {
                        day += d2;
                    } else {
                        day += days[l];
                    }
                }
                System.out.printf("#%d %d", k+1, day);
            }
        }
    }
}
