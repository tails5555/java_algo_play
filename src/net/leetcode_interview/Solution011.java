package net.leetcode_interview;

// Leetcode Interview Question No. 11
// 욕조에 채울 물의 용량 최댓값 구하기 문제
public class Solution011 {
    public static int maxArea(int[] height) {
        int max_area = Integer.MIN_VALUE;
        int i = 0, j = height.length - 1;
        while(i < j){
            max_area = Math.max(max_area, Math.abs(i - j) * Math.min(height[i], height[j]));
            if(height[i] < height[j]) {
                i += 1;
            } else {
                j -= 1;
            }
        }

        return max_area;
    }

    public static void main(String[] args){
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }
}
