package net.hackerrank.search;

import java.util.Arrays;

// Hacker Rank 탐색 문제
// Minimum Time Required 문제
// 이진 탐색 응용 문제
public class Example05 {
    static long minTime(long[] machines, long goal) {
        Arrays.sort(machines);

        long start = (long) Math.ceil((double) goal / machines.length) * machines[0];
        long end = (long) Math.ceil((double) goal / machines.length) * machines[machines.length - 1];

        while(start < end){
            long mid = (start + end) / 2;
            long sum = 0L;
            for(int k = 0; k < machines.length; k++) {
                sum += (mid / machines[k]);
            }
            if(sum >= goal) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return start;
    }

    public static void main(String[] args){
        System.out.println(minTime(new long[] { 2, 3 }, 5L));
        System.out.println(minTime(new long[] { 1, 3, 4 }, 10L));
        System.out.println(minTime(new long[] { 4, 5, 6 }, 12L));
    }
}
