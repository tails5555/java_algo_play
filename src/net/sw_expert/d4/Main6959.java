package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D4 이상한 나라의 덧셈게임 문제 풀이
public class Main6959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            String num = br.readLine();
            int cnt = 0;
            int sum = 0;
            for(int l = 0; l < num.length(); l++){
                sum += (num.charAt(l) - '0');
                cnt += 1;
                if(sum >= 10){
                    sum = sum / 10 + sum % 10;
                    cnt += 1;
                }
            }
            System.out.printf("#%d %s\n", k + 1, cnt % 2 == 0 ? "A" : "B");
        }
    }
}
