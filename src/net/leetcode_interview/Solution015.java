package net.leetcode_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Leetcode Interview Question No. 15
// 세 수로 0 을 만들 수 있는 집합의 수를 구하는 문제
// 시간 초과. 줄이는 방법에 대해선 다음에 알아보겠음.
public class Solution015 {
    static List<List<Integer>> zeroList;
    static int[] values;
    static void backtracking(int idx, Stack<Integer> list, int total) {
        if(idx == values.length) {
            if (list.size() == 3 && total == 0) {
                List<Integer> tmp = new ArrayList<>(list);
                if(!zeroList.contains(tmp))
                    zeroList.add(tmp);
            }
            return;
        }

        list.push(values[idx]);
        backtracking(idx + 1, list, total + values[idx]);
        list.pop();
        backtracking(idx + 1, list, total);
    }

    public static List<List<Integer>> threeSum(int[] nums){
        zeroList = new ArrayList<>();
        values = nums;
        Arrays.sort(values);
        backtracking(0, new Stack<>(), 0);
        return zeroList;
    }

    public static void main(String[] args){
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
}
