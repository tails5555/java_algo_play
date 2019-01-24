package net.hackerrank.hash;

import java.util.HashSet;
import java.util.Set;

// Hacker Rank Hash Table 문제
// Two Strings 문제
public class Example02 {
    static String twoStrings(String s1, String s2) {
        Set<Character> c1 = new HashSet<>();
        Set<Character> c2 = new HashSet<>();
        for(char c : s1.toCharArray()) {
            if(c1.size() == 26) break;
            c1.add(c);
        }
        for(char c : s2.toCharArray()) {
            if(c2.size() == 26) break;
            c2.add(c);
        }

        c1.retainAll(c2);

        if(c1.size() > 0) return "YES";
        else return "NO";
    }

    public static void main(String[] args){
        System.out.println(twoStrings("be", "cat"));
        System.out.println(twoStrings("a", "art"));
        System.out.println(twoStrings("a", "and"));
        System.out.println(twoStrings("and", "art"));
        System.out.println(twoStrings("hello", "world"));
        System.out.println(twoStrings("hi", "world"));
    }
}
