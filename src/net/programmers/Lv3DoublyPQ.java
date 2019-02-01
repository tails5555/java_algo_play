package net.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// Programmers Heap 응용 문제(이중우선순위큐)
public class Lv3DoublyPQ {
    public static int[] solution(String[] operations) {
        Set<Integer> removes = new HashSet<>();

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int k = 0; k < operations.length; k++){
            String[] token = operations[k].split(" ");
            switch(token[0]) {
                case "I" :
                    minQueue.offer(Integer.parseInt(token[1]));
                    maxQueue.offer(Integer.parseInt(token[1]));
                    break;
                case "D" :
                    int od = Integer.parseInt(token[1]);
                    if(od > 0) {
                        while(!maxQueue.isEmpty()) {
                            int tmp = maxQueue.poll();
                            if(!removes.contains(tmp)) {
                                removes.add(tmp);
                                break;
                            }
                        }
                    } else {
                        while(!minQueue.isEmpty()) {
                            int tmp = minQueue.poll();
                            if(!removes.contains(tmp)) {
                                removes.add(tmp);
                                break;
                            }
                        }
                    }
                    break;
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        if(maxQueue.size() > 0) {
            while(!maxQueue.isEmpty()) {
                int tmp = maxQueue.poll();
                if(!removes.contains(tmp)) {
                    max = Math.max(max, tmp);
                    break;
                }
            }
        }

        if(minQueue.size() > 0) {
            while(!minQueue.isEmpty()) {
                int tmp = minQueue.poll();
                if(!removes.contains(tmp)) {
                    min = Math.min(min, tmp);
                    break;
                }
            }
        }

        return new int[] { max == Integer.MIN_VALUE ? 0 : max, min == Integer.MAX_VALUE ? 0 : min };
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new String[] { "I 16", "D 1" })));
        System.out.println(Arrays.toString(solution(new String[] { "I 7", "I 5", "I -5", "D -1" })));
        System.out.println(Arrays.toString(solution(new String[] { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" })));
    }
}
