package net.leetcode_interview;

import java.util.HashMap;
import java.util.Map;

// Leetcode Interview Question No. 3
// 슬라이딩 윈도우 + 해시 테이블 활용 여부 문제.
// 풀이 참조함...ㅜ
public class Solution003 {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int j = 0;

        Map<Character, Integer> map = new HashMap<>();
        for(int k = 0; k < s.length(); k++){
            if(map.containsKey(s.charAt(k))){
                j = Math.max(j, map.get(s.charAt(k)));
            }
            res = Math.max(res, k - j + 1);
            map.put(s.charAt(k), k + 1);
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("pkjmrovkjouaqnebjfjaut"));
    }
}
