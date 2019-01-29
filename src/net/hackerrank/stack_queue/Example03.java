package net.hackerrank.stack_queue;

import java.util.Stack;

// Hacker Rank Stack, Queue 응용 문제
// Largest Rectangle 문제 (워낙 유명한 문제)
public class Example03 {
    static long largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack<>();
        long res = 0L;
        int i = 0;
        while(i < h.length) {
            boolean checked = stack.isEmpty();
            if(!checked)
                checked = h[stack.peek()] <= h[i];

            if(checked) {
                stack.add(i);
                i++;
            } else {
                int end = stack.pop();
                long width;
                if(!stack.isEmpty()) {
                    width = i - stack.peek() - 1;
                } else {
                    width = i;
                }
                res = Math.max(res, h[end] * width);
            }
        }

        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            long width;
            if(!stack.isEmpty()) {
                width = i - stack.peek() - 1;
            } else {
                width = i;
            }
            res = Math.max(res, h[tmp] * width);
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(largestRectangle(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(largestRectangle(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
    }
}
