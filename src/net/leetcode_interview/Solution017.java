package net.leetcode_interview;

import java.util.ArrayList;
import java.util.List;

// Leetcode Interview Question No. 17
// 휴대폰 알파벳 입력 알고리즘 문제 풀이
public class Solution017 {
    static String[] phone = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    static char[] command;
    static List<String> result;

    public static void backtracking(int idx, String message){
        if(idx == command.length){
            result.add(message);
            return;
        }

        int t = command[idx] - '0';
        for(int k = 0; k < phone[t].length(); k++){
            backtracking(idx + 1, message + phone[t].charAt(k));
        }
    }

    public static List<String> letterCombinations(String digits) {
        command = digits.toCharArray();
        result = new ArrayList<>();
        if(digits.length() != 0 && digits != null)
            backtracking(0, "");
        return result;
    }

    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("32"));
    }
}
