package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 성공적인 공연 기획 문제 풀이
// 문제 이해가 안 가서 풀이 참조함. 어떻게 백트래킹 문제보다 이해하기 어렵게 만들어놨는지 나원...
public class Main4789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            char[] claps = br.readLine().toCharArray();
            int emp = 0;
            int clappers = 0;
            for(int l = 0; l < claps.length; l++){
                int add = claps[l] - '0';
                if(clappers >= l) {
                    clappers += add;
                } else {
                    emp += (l - clappers);
                    clappers = (l + add);
                }
            }
            System.out.printf("#%d %d\n", k + 1, emp);
        }
    }
}
