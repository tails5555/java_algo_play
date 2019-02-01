package net.programmers;

import java.util.Collections;
import java.util.PriorityQueue;

// Programmers Heap 응용 문제(라면 공장)
// 풀이 참조...ㅜ
public class Lv2Ramen {
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int day = stock;
        int idx = 0, tmp = 0, answer = 0;
        while(day < k) {
            for(int i = idx; i < dates.length; i++){
                if(dates[i] <= day){
                    queue.offer(supplies[i]);
                    tmp = i;
                }
            }
            idx = tmp + 1;
            day += queue.poll();
            answer += 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[] { 4, 10, 15 }, new int[] { 20, 5, 10 }, 30));
    }
}
