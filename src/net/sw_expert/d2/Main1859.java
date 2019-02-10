package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 백만 장자 프로젝트 문제 풀이
public class Main1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());

            int[] price = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while(st.hasMoreTokens()) {
                price[idx++] = Integer.parseInt(st.nextToken());
            }

            long margin = 0L;
            long max_price = price[N - 1];
            for(int l = N - 2; l >= 0; l--){
                if(max_price > price[l])
                    margin += (max_price - price[l]);
                else
                    max_price = Math.max(max_price, price[l]);
            }
            System.out.printf("#%d %d\n", k+1, margin);
        }
    }
}
