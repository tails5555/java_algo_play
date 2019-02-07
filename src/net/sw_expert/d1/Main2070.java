package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성 SW Expert D1 비교 관련 문제
public class Main2070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            String test = String.format("#%d ", k + 1);
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A < B) {
                System.out.println(test + "<");
            } else if(A > B){
                System.out.println(test + ">");
            } else {
                System.out.println(test + "=");
            }
        }
    }
}
