package net.leetcode_interview;

// Leetcode Interview Question No. 7
// Integer 를 거꾸로 문제
public class Solution007 {
    public static int reverse(int x) {
        int d = x > 0 ? 1 : -1;
        long res = 0;
        long init = Math.abs(x);
        long tmp = (int) Math.pow(10, (int) Math.log10(init));
        for(long k = init; k > 0; k /= 10){
            res += (k % 10 * tmp);
            tmp /= 10;
        }
        if(res <= Integer.MAX_VALUE && res >= Integer.MIN_VALUE) {
            return d * (int) res;
        } else return 0;
    }

    public static void main(String[] args){
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }
}
