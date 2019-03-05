package net.leetcode_interview;

// Leetcode Interview Question No. 14
// 가장 긴 공통 전두 단어 찾기 문제
public class Solution014 {
    static String prefixFinder(String left, String right){
        int len = Math.min(left.length(), right.length());
        for(int k = 0; k < len; k++){
            if(left.charAt(k) != right.charAt(k))
                return left.substring(0, k);
        }
        return left.substring(0, len);
    }

    static String divideConquer(String[] strs, int start, int end){
        if(start == end) return strs[start];
        else {
            int mid = (start + end) / 2;
            String left = divideConquer(strs, start, mid);
            String right = divideConquer(strs, mid + 1, end);
            return prefixFinder(left, right);
        }
    }

    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0 || strs == null) return "";
        else return divideConquer(strs, 0, strs.length - 1);
    }

    public static void main(String[] args){
        System.out.println(longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
    }
}
