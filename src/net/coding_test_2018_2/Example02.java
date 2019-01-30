package net.coding_test_2018_2;

import java.util.PriorityQueue;

// 프로그래머스 2018 하반기 모의고사 2번
// 조선소 배상비용 최소화 문제
public class Example02 {
    static int solution(int N, int[] arr){
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int k = 0; k < arr.length; k++){
            queue.add(arr[k]);
        }
        for(int k = 0; k < N; k++){
            int work = queue.poll();
            if(work == 0) break;
            queue.offer(work - 1);
        }

        int ans = 0;
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            ans += (tmp * tmp);
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(solution(4, new int[] { 4, 3, 3 }));
        System.out.println(solution(5, new int[] { 4, 3, 3 }));
    }
}
