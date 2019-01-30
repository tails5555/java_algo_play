package net.hackerrank.stack_queue;

import java.util.Arrays;
import java.util.LinkedList;

// Hacker Rank Stack, Queue 응용 문제
// Min Max Riddle 문제
// 시뮬레이션 방식으로 접근하면 상당히 쉬워 보이지만, 시간 복잡도를 더욱 고려하면 좀 까다로운 문제.
// 슬라이딩 윈도우를 사용해서 풀었지만, 2 ~ 4번 케이스에서 탈락을 하였음. 나중에 다시 풀어보도록 함.
public class Example04 {
    static long sliding_window(long[] arr, int size) {
        long res = Long.MIN_VALUE;

        LinkedList<long[]> deque = new LinkedList<>();
        for(int k = 0; k < arr.length; k++){
            while(!deque.isEmpty() && deque.peekLast()[0] >= arr[k])
                deque.removeLast();

            deque.addLast(new long[] { arr[k], k });

            while(deque.peekFirst()[1] <= k - size)
                deque.removeFirst();

            if(k + 1 >= size)
                res = Math.max(res, deque.peekFirst()[0]);
        }

        return res;
    }

    static long[] riddle(long[] arr) {
        long[] res = new long[arr.length];
        for(int k=0;k<arr.length;k++){
            res[k] = sliding_window(arr, k + 1);
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(riddle(new long[] { 2, 6, 1, 12 })));
        System.out.println(Arrays.toString(riddle(new long[] { 1, 2, 3, 5, 1, 13, 3 })));
        System.out.println(Arrays.toString(riddle(new long[] { 3, 5, 4, 7, 6, 2 })));
    }
}
