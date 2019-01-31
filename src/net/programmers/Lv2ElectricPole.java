package net.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

// 프로그래머스 탑 문제(이렇게 풀이하는 방법까지 알아야 할까?)
public class Lv2ElectricPole {
    public static int[] solution(int[] heights) {
        int[] revHeight = IntStream.rangeClosed(1, heights.length).map(i -> heights[heights.length-i]).toArray();
        LinkedList<Integer> res = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int k = 0; k < heights.length; k++)
            queue.offer(revHeight[k]);

        int pos = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int k;
            for (k = pos; k < revHeight.length; k++) {
                if (cur < revHeight[k]) break;
            }
            pos++;

            res.addFirst(revHeight.length - k);
        }

        return res.stream().mapToInt(v -> v).toArray();
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[] { 6, 9, 5, 7, 4 })));
        System.out.println(Arrays.toString(solution(new int[] { 3, 9, 9, 3, 5, 7, 2 })));
        System.out.println(Arrays.toString(solution(new int[] { 1, 5, 3, 6, 7, 6, 5 })));
    }
}
