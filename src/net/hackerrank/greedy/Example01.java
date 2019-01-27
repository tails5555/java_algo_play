package net.hackerrank.greedy;

import java.util.Arrays;

// Hacker Rank 탐욕 알고리즘 문제
// Minimum Absolute Difference in an Array 문제
public class Example01 {
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for(int k=1;k<arr.length;k++){
            ans = Math.min(ans, arr[k] - arr[k-1]);
        }
        return ans;
    }

    public static void main(String[] args){
        System.out.println(minimumAbsoluteDifference(new int[] { -59, -36, -13, 1, -53, -92, -2, -96, -54, 75 }));
        System.out.println(minimumAbsoluteDifference(new int[] { 1, -3, 71, 68, 17 }));
    }
}
