package net.hackerrank.sort;

import java.util.PriorityQueue;

// Hacker Rank Sorting 문제
// Mark And Toy 문제
public class Example02 {
    static int maximumToys(int[] prices, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        for(int i=0;i<prices.length;i++){
            queue.offer(prices[i]);
        }

        int tmp = 0;
        int cnt = 0;
        while(!queue.isEmpty()) {
            tmp += queue.poll();
            if(tmp > k) break;
            cnt += 1;
        }

        return cnt;
    }

    public static void main(String[] args){
        System.out.println(maximumToys(new int[] { 1, 12, 5, 111, 200, 1000, 10 }, 50));
    }
}
