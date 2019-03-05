package net.leetcode_interview;

import java.util.HashMap;
import java.util.Map;

// Leetcode Interview Question No. 13
// 로마 숫자를 Integer 로 변환하는 문제
public class Solution013 {
    static Map<Character, Integer> roman = new HashMap<Character, Integer>() {
        {
            put('I', 1); put('V', 5); put('X', 10); put('L', 50); put('C', 100); put('D', 500); put('M', 1000);
        }
    };

    public static int romanToInt(String s){
        int res = 0;
        char[] alps = s.toCharArray();
        for(int k = 0; k < alps.length; k++){
            res += roman.get(alps[k]);
            if(k > 0){
                if((alps[k] == 'V' || alps[k] == 'X') && alps[k - 1] == 'I'){
                    res -= 2;
                }
                if((alps[k] == 'L' || alps[k] == 'C') && alps[k - 1] == 'X'){
                    res -= 20;
                }
                if((alps[k] == 'D' || alps[k] == 'M') && alps[k - 1] == 'C'){
                    res -= 200;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("XII"));
        System.out.println(romanToInt("XIV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
