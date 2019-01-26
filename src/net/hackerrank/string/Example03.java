package net.hackerrank.string;

import java.util.Map;
import java.util.TreeMap;

// Hacker Rank String 문제
// Sherlock and the Valid String 문제
// 같은 횟수의 알파벳을 추리하는 문제
public class Example03 {
    static String isValid(String s) {
        int[] alps = new int[26];
        char[] word = s.toCharArray();
        Map<Integer, Integer> counter = new TreeMap<>();
        for(char c : word){
            int before = alps[c - 'a'];
            int after = before + 1;
            alps[c - 'a'] = after;

            if(before != 0) {
                int before_freq = counter.getOrDefault(before, 0);
                if(before_freq > 1) counter.put(before, before_freq - 1);
                else counter.remove(before);
            }

            int freq = counter.getOrDefault(after, 0);
            counter.put(after, ++freq);
        }

        if(counter.size() == 1) return "YES";
        else {
            if(counter.size() > 2) return "NO";
            else {
                if(counter.values().contains(1)) {
                    int[] key = counter.keySet().stream().mapToInt(Number::intValue).toArray();
                    int[] value = counter.values().stream().mapToInt(Number::intValue).toArray();
                    if(Math.abs(key[0] - key[1]) > 1) {
                        if(key[0] == 1 && value[0] == 1) return "YES";
                        else return "NO";
                    } else {
                        return "YES";
                    }
                } else return "NO";
            }
        }
    }

    public static void main(String[] args){
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println(isValid("abcabcabcd"));
        System.out.println(isValid("ab"));
    }
}
