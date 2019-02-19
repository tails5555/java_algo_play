package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// SW Expert D4 괄호 짝짓기 문제 풀이
public class Main1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int k = 0; k < 10; k++) {
            int N = Integer.parseInt(br.readLine());
            char[] tmp = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean validate = true;
            for(int l = 0; l < N; l++){
                char ele = tmp[l];
                if(ele == '<' || ele == '(' || ele == '{' || ele == '['){
                    stack.push(ele);
                } else {
                    if(!stack.isEmpty()) {
                        if (ele == '>' && stack.peek() == '<') stack.pop();
                        else if (ele == ')' && stack.peek() == '(') stack.pop();
                        else if (ele == '}' && stack.peek() == '{') stack.pop();
                        else if (ele == ']' && stack.peek() == '[') stack.pop();
                        else {
                            validate = false;
                            break;
                        }
                    } else {
                        validate = false;
                        break;
                    }
                }
            }

            System.out.printf("#%d %d\n", k+1, validate ? 1 : 0);
        }
    }
}
