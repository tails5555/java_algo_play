package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 2016년 요일 맞추기 문제 풀이
public class Main5515 {
    static final int[] month_day = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static final int new_day = 4; // 2016년 1월 1일이 금요일임.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            int difference = -1;
            for(int l = 1; l < month; l++)
                difference += month_day[l];
            difference += day;

            System.out.printf("#%d %d\n", k + 1, (new_day + difference) % 7);
        }
    }
}
