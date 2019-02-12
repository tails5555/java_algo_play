package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// SW Expert D3 비밀번호 문제 풀이
public class Main1234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int k = 0; k < 10; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            char[] tmp = st.nextToken().toCharArray();
            Stack<Character> stack = new Stack<>();
            stack.push(' ');
            for(int l = 0; l < tmp.length; l++){
                if(stack.peek() == tmp[l])
                    stack.pop();
                else
                    stack.push(tmp[l]);
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                char c = stack.pop();
                if(c != ' ')
                    sb.append(c);
            }
            sb.reverse();
            System.out.printf("#%d %s\n", k+1, sb.toString());
        }
    }
}
