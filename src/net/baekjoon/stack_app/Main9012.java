package net.baekjoon.stack_app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Baekjoon 9012 번 문제 괄호 풀이
public class Main9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int k=0;k<N;k++){
            Stack<Character> stack = new Stack<>();
            String token = br.readLine();
            boolean valid = true;
            for(char c : token.toCharArray()){
                if(c == '(') {
                    stack.push(c);
                } else {
                    if(stack.isEmpty()){
                        valid = false;
                        break;
                    } else stack.pop();
                }
            }
            if(valid && stack.size() == 0){
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
    }
}
