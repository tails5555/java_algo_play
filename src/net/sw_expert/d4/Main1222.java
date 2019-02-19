package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// SW Expert D4 계산기 1~3 문제 풀이
// 마이구미 중위 -> 후위 변환 참조.
public class Main1222 {
    public static int priority(char ch) {
        switch (ch) {
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            case '(':
            case ')':
                return 0;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k = 0; k < 10; k++){
            int N = Integer.parseInt(br.readLine());
            char[] in = br.readLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for(int l = 0; l < in.length; l++){
                int p = priority(in[l]);
                switch(in[l]){
                    case '+' :
                    case '*' :
                        while(!stack.isEmpty() && priority(stack.peek()) >= p)
                            sb.append(stack.pop());
                        stack.push(in[l]);
                        break;
                    case '(' :
                        stack.push(in[l]);
                        break;
                    case ')' :
                        while(!stack.isEmpty() && stack.peek() != '(')
                            sb.append(stack.pop());
                        stack.pop();
                        break;
                    default :
                        sb.append(in[l]);
                        break;
                }
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            Stack<Integer> tmp = new Stack<>();
            char[] post = sb.toString().toCharArray();
            for(int l = 0; l < post.length; l++){
                if(post[l] >= '0' && post[l] <= '9')
                    tmp.push(post[l] - '0');
                else {
                    int t1 = tmp.pop();
                    int t2 = tmp.pop();
                    switch(post[l]){
                        case '+' :
                            tmp.push(t1 + t2);
                            break;
                        case '*' :
                            tmp.push(t1 * t2);
                            break;
                    }
                }
            }

            System.out.printf("#%d %d\n", k+1, tmp.peek());
        }
    }
}
