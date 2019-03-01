package net.leetcode_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Leetcode Interview Question No. 1
// 두 수의 덧셈
public class Solution001 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int k = 0; k < nums.length; k++){
            List<Integer> list = map.getOrDefault(nums[k], new ArrayList<>());
            list.add(k);
            map.put(nums[k], list);
        }

        int[] res = new int[2];
        for(int a : map.keySet()){
            int tmp = target - a;
            if(map.containsKey(tmp)){
                List<Integer> t0 = map.get(a);
                List<Integer> t1 = map.get(tmp);

                if(t0.size() != 2) {
                    res[0] = t0.get(0);
                    res[1] = t1.get(0);
                } else {
                    res[0] = t0.get(0);
                    res[1] = t0.get(1);
                }

                if (res[0] > res[1]) {
                    int temp = res[0];
                    res[0] = res[1];
                    res[1] = temp;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        String tmp1 = Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9));
        System.out.println(tmp1);
        String tmp2 = Arrays.toString(twoSum(new int[] { 3, 3 }, 6));
        System.out.println(tmp2);
    }
}
