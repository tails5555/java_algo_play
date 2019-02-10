package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// SW Expert D2 초심자의 회문 검사 문제 풀이
public class Main1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            char[] tmp = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            int mid = (tmp.length - 1) / 2;
            for(int l = 0; l <= mid; l++){
                stack.push(tmp[l]);
            }

            boolean isPalindrome = true;
            int idx = mid + 1;
            if(tmp.length % 2 != 0) {
                stack.pop();
            }
            while(!stack.isEmpty()){
                char cur = stack.pop();
                if(cur != tmp[idx++]){
                    isPalindrome = false;
                    break;
                }
            }

            System.out.printf("#%d %d\n", k+1, isPalindrome ? 1 : 0);
        }
    }
}
