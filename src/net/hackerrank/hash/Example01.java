package net.hackerrank.hash;

import java.util.HashMap;
import java.util.Map;

// Hacker Rank Hash Table 문제
// Ransom Note 문제
public class Example01 {
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> dic = new HashMap<>();
        for(String s : magazine){
            if(dic.containsKey(s)) {
                int cnt = dic.get(s);
                dic.put(s, cnt + 1);
            } else {
                dic.put(s, 1);
            }
        }

        boolean complete = true;
        for(String s : note) {
            if(dic.containsKey(s)){
                int cnt = dic.get(s);
                if(cnt == 0) {
                    complete = false;
                    break;
                }
                else {
                    dic.put(s, cnt - 1);
                }
            } else {
                complete = false;
                break;
            }
        }

        if(complete) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args){
        checkMagazine(new String[] { "give", "me", "one", "grand", "today", "night" }, new String[] { "give", "one", "grand", "today" });
        checkMagazine(new String[] { "two", "times", "three", "is", "not", "four" }, new String[] { "two", "times", "two", "is", "four" });
        checkMagazine(new String[] { "ive", "got", "a", "lovely", "bunch", "of", "coconuts" }, new String[] { "ive", "got", "some", "coconuts" });
    }
}
