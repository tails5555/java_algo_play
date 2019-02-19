package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 세상의 모든 회문 2
public class Main4579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            char[] tmp = br.readLine().toCharArray();
            boolean hasPalindrome = true;
            for(int l = 0; l < tmp.length / 2; l++){
                if(tmp[l] == '*') break;
                if(tmp[tmp.length - 1 - l] == '*') break;
                if(tmp[l] != tmp[tmp.length - 1 - l]) {
                    hasPalindrome = false;
                    break;
                }
            }
            if(!hasPalindrome) {
                System.out.printf("#%d Not exist\n", k+1);
            } else {
                System.out.printf("#%d Exist\n", k+1);
            }
        }
    }
}
