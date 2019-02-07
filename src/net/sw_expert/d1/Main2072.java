package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성 SW Expert D1 홀수만 더하기 문제
public class Main2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int tmp = 0;
            while(st.hasMoreTokens()) {
                int val = Integer.parseInt(st.nextToken());
                if(val % 2 == 1)
                    tmp += val;
            }
            String test = String.format("#%d ", k + 1);
            System.out.println(test + tmp);
        }
    }
}
