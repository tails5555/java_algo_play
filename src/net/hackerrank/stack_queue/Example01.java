package net.hackerrank.stack_queue;

import java.util.Stack;

// Hacker Rank Stack, Queue 응용 문제
// Balanced Brackets 문제
public class Example01 {
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        char[] brackets = s.toCharArray();
        String res = "YES";
        for(int k=0;k<brackets.length;k++){
            if(brackets[k] == '(' || brackets[k] == '{' || brackets[k] == '[')
                stack.push(brackets[k]);
            else if(brackets[k] == ')' || brackets[k] == '}' || brackets[k] == ']') {
                if(stack.isEmpty()) {
                    res = "NO";
                    break;
                } else {
                    char tmp = stack.pop();
                    if(brackets[k] == ')' && tmp != '(') {
                        res = "NO";
                        break;
                    }
                    if(brackets[k] == '}' && tmp != '{') {
                        res = "NO";
                        break;
                    }
                    if(brackets[k] == ']' && tmp != '[') {
                        res = "NO";
                        break;
                    }
                }
            }
        }

        if(stack.isEmpty()) return res;
        else return "NO";
    }

    public static void main(String[] args){
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
        System.out.println(isBalanced("{{}"));
    }
}
