package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// SW Expert D3 세상의 모든 회문
public class Main4522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int k = 0; k < T; k++) {
            char[] tmp = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for(int l = 0; l < Math.ceil(tmp.length / 2.0); l++){
                stack.push(tmp[l]);
            }
            if(tmp.length % 2 != 0) stack.pop();
            int mid = (int) Math.ceil(tmp.length / 2.0);
            boolean hasPalindrome = true;
            for(int l = mid; l < tmp.length; l++){
                char c = stack.pop();
                if(c != tmp[l] && c != '?' && tmp[l] != '?') {
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
