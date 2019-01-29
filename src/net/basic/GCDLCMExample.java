package net.basic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 최대공약수, 최소공배수 알고리즘
public class GCDLCMExample {
    public static long pair_lcm(long num1, long num2) {
        if(num1 % num2 == 0) return num1;
        if(num2 % num1 == 0) return num2;
        long start = Math.min(num1, num2);
        long end = num1 * num2;

        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[] { start, end });

        long ans = Long.MAX_VALUE;
        while(!queue.isEmpty()){
            long[] tmp = queue.poll();
            if(tmp[0] <= tmp[1]) {
                long mid = (tmp[0] + tmp[1]) / 2;
                if(mid % num1 == 0 && mid % num2 == 0) {
                    ans = Math.min(ans, mid);
                }
                queue.offer(new long[] { tmp[0], mid - 1 });
                queue.offer(new long[] { mid + 1, tmp[1] });
            }
        }

        return ans;
    }

    public static long multiple_lcm(long[] nums){
        if(Arrays.stream(nums).filter(n -> n == 0L).count() == 0) {
            long ans = 1L;
            for(int k=0;k<nums.length;k++){
                ans = pair_lcm(ans, nums[k]);
            }
            return ans;
        } else return 0L;
    }

    public static void main(String[] args){
        System.out.println(pair_lcm(10L, 8L));
        System.out.println(pair_lcm(15L, 6L));
        System.out.println(pair_lcm(14L, 8L));
        System.out.println(pair_lcm(15L, 4L));
        System.out.println(pair_lcm(3L, 9L));

        System.out.println(multiple_lcm(new long[] { 1L, 2L, 3L }));
        System.out.println(multiple_lcm(new long[] { 2L, 9L, 3L, 12L }));
        System.out.println(multiple_lcm(new long[] { 1L, 2L, 3L, 4L, 5L }));
        System.out.println(multiple_lcm(new long[] { 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L }));
    }
}
