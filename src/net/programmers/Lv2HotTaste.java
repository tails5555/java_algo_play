package net.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

// Programmers Heap 응용 문제(더 맵게)
public class Lv2HotTaste {
    public static int solution(int[] scoville, int K) {
        Arrays.sort(scoville);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int k=0;k<scoville.length;k++){
            queue.offer(scoville[k]);
        }

        int cnt = 0;
        while(!queue.isEmpty()) {
            boolean checked = true;
            for(int a : queue) {
                if(a < K) {
                    checked = false;
                    break;
                }
            }

            if(!checked) {
                int cur1 = queue.poll();
                int taste = cur1;

                if(queue.size() > 0) {
                    int cur2 = queue.poll();
                    taste += (cur2 * 2);
                    cnt += 1;
                    queue.offer(taste);
                } else {
                    if(taste < K) break;
                }
            } else {
                return cnt;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
    }
}
