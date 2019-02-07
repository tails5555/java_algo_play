package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성 SW Expert D1 평균 구하기 문제
public class Main2071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int tmp = 0;
            while(st.hasMoreTokens()) {
                tmp += Integer.parseInt(st.nextToken());
            }
            String test = String.format("#%d ", k + 1);
            System.out.println(test + (int) Math.round(tmp / 10.0));
        }
    }
}
