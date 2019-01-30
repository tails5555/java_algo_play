package net.hackerrank.recursion;

// Hacker Rank 재귀 함수 응용 문제
// Digit Sum 문제
public class Example03 {
    static long string_to_digit_sum(String tmp) {
        long res = 0;
        for(char c : tmp.toCharArray()) {
            res += (c - '0');
        }
        return res;
    }

    static int digit_sum(long value) {
        if(value >= 0 && value <= 9) return (int) value;
        int sum = 0;
        long tmp = value;
        while(tmp > 0) {
            sum += (tmp % 10);
            tmp /= 10;
        }
        return digit_sum(sum);
    }

    static int superDigit(String n, int k) {
        long start = string_to_digit_sum(n) * k;
        return digit_sum(start);
    }

    public static void main(String[] args){
        System.out.println(superDigit("123", 3));
        System.out.println(superDigit("9875", 4));
    }
}
