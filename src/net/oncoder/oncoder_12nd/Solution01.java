package net.oncoder.oncoder_12nd;

import java.util.PriorityQueue;

// 온코더 12회 공식테스트 1번
public class Solution01 {
    public static int solution(int n, int[] v, int[] ex){
        int[] count = new int[n];
        int[] vote = new int[n];

        for(int k = 0; k < v.length; k++) {
            count[v[k]] += 1;
            vote[ex[k]] += 1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[2] == o2[2]) {
                if(o1[1] != o2[1]) return o2[1] - o1[1];
                else return o1[0] - o2[0];
            } else {
                return o2[2] - o1[2];
            }
        });

        for(int k = 0; k < n; k++){
            pq.offer(new int[] { k, count[k], vote[k] });
        }

        int[] first = pq.poll();
        return first[0];
    }

    public static void main(String[] args){
        System.out.println(solution(3, new int[] { 0, 1, 2, 2 }, new int[] { 2, 2, 0, 1 }));
        System.out.println(solution(3, new int[] { 0, 2, 2 }, new int[] { 2, 0, 1 }));
        System.out.println(solution(2, new int[] { 0, 1 }, new int[] { 1, 0 }));
        System.out.println(solution(5, new int[] {} , new int[] {}));
    }
}
