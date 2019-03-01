package net.leetcode_interview;

// Leetcode Interview Question No. 8
// 풀이 참조... atoi 문제
public class Solution008 {
    public static int myAtoi(String str) {
        if (str == null || str.length() < 1)
            return 0;
        else {
            str = str.trim();
            if(str.length() < 1) return 0;

            char flag = '+';
            int i = 0;
            if (str.charAt(0) == '-') {
                flag = '-';
                i++;
            } else if (str.charAt(0) == '+') {
                i++;
            }
            double result = 0;

            while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result = result * 10 + (str.charAt(i) - '0');
                i++;
            }

            if (flag == '-')
                result = -result;

            if (result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            return (int) result;
        }
    }

    public static void main(String[] args){
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words with 897"));
        System.out.println(myAtoi("+10"));
        System.out.println(myAtoi("-91283472332"));
    }
}
