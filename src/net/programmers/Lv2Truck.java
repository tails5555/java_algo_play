package net.programmers;

import java.util.LinkedList;
import java.util.Stack;

// 프로그래머스 다리를 지나는 트럭 문제(풀이 참조)
public class Lv2Truck {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Stack<Integer> stack = new Stack<>();
        for(int k : truck_weights) {
            stack.add(k);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int k = 0; k < bridge_length; k++)
            queue.offer(0);

        int res = 0;
        while(!queue.isEmpty()) {
            res += 1;
            queue.pollFirst();
            int sum = 0;
            for(int w : queue) {
                sum += w;
            }
            if(!stack.isEmpty()) {
                if (sum + stack.peek() <= weight)
                    queue.offerLast(stack.pop());
                else
                    queue.offerLast(0);
            }
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(solution(2, 10, new int[] { 7, 4, 5, 6 }));
        System.out.println(solution(100, 100, new int[] { 10 }));
        System.out.println(solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }));
    }
}
