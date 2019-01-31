package net.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

// 프로그래머스 기능 개발 문제
public class Lv2Progress {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] day = new int[progresses.length];
        for(int k = 0; k < day.length; k++){
            day[k] = (int) Math.ceil((double) Math.abs(progresses[k] - 100) / speeds[k]);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        LinkedList<Integer> res = new LinkedList<>();

        int cnt = 0;
        for(int k = 0; k <= day.length; k++){
            if(k == day.length) {
                res.addLast(cnt);
            } else {
                if(!queue.isEmpty()) {
                    if(day[k] > queue.peek()) {
                        res.addLast(cnt);
                        cnt = 0;
                    }
                }
                queue.offer(day[k]);
                cnt += 1;
            }
        }

        return res.stream().mapToInt(m -> m).toArray();
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(
            solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 })
        ));
    }
}
