package net.programmers;

import java.util.Stack;

public class Lv2MetalStick {
    public static int solution(String arrangement) {
        Stack<Integer> stack = new Stack<>();
        char[] tmp = arrangement.toCharArray();
        int answer = 0;
        for(int k = 0; k < tmp.length; k++){
            if(tmp[k] == '(') {
                stack.push(k);
            } else {
                if(stack.peek() + 1 == k) {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer += 1;
                }
            }
        }

        answer += stack.size();
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("()(((()())(())()))(())"));
        System.out.println(solution("((()))(())"));
    }
}
