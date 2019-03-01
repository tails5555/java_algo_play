package net.leetcode_interview;

// Leetcode Interview Question No. 9
// 숫자 회문 문제
public class Solution009 {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        else {
            String tmp = String.valueOf(x);
            boolean res = true;
            for(int k = 0; k < tmp.length() / 2; k++){
                res = res && tmp.charAt(k) == tmp.charAt(tmp.length() - 1 - k);
            }
            return res;
        }
    }

    public static void main(String[] args){
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(12121));
        System.out.println(isPalindrome(1221));
    }
}
