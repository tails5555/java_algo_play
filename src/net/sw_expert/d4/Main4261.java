package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 빠른 휴대전화 키패드 문제 풀이
// String equals 메소드의 시간 복잡도는 글자 수가 같으면 O(1), 다르면 O(n) 이란다.
public class Main4261 {
    static final char[] buttons = {
        '2', '2', '2', // ABC
        '3', '3', '3', // DEF
        '4', '4', '4', // GHI
        '5', '5', '5', // JKL
        '6', '6', '6', // MNO
        '7', '7', '7', '7', // PQRS
        '8', '8', '8', // TUV
        '9', '9', '9', '9' // WXYZ
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            String keypad = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            int cnt = 0;
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                char[] tmp = st.nextToken().toCharArray();
                if(tmp.length == keypad.length()) {
                    for(int l = 0; l < tmp.length; l++){
                        int alp = tmp[l] - 'a';
                        tmp[l] = buttons[alp];
                    }
                    if(new String(tmp).equals(keypad)) cnt += 1;
                }
            }

            System.out.printf("#%d %d\n", k + 1, cnt);
        }
    }
}
