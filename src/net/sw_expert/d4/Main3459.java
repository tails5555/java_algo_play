package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D4 승자 예측하기 문제 풀이
// 4의 제곱 여부에 따른 승자 구분을 위한 문제였음.
public class Main3459 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            long N = Long.parseUnsignedLong(br.readLine());
            long mul = 1L;
            long turn = 1L;

            boolean checked = false;
            while(turn < N){
                if(!checked)
                    mul *= 4L;
                turn += mul;
                checked = !checked;
            }

            System.out.printf("#%d %s\n", k + 1, checked ? "Alice" : "Bob");
        }
    }
}

// (1)
// 좌는 Alice, 우는 Bob
// (2 ~ 5) (6 ~ 9) 4 차이
// (10 ~ 25) (26 ~ 41) 16 차이
// (42 ~ 105) (106 ~ 169) 64 차이
// ... 1일 땐 Bob 가 이기고, Alice, Bob 순서대로 차이가 난다. 이를 구성해야 할 필요가 있다.