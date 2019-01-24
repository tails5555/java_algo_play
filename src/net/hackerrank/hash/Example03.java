package net.hackerrank.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Hacker Rank Hash Table 문제
// Sherlock And Anagrams 문제
public class Example03 {
    static int sherlockAndAnagrams(String s) {
        char[] tmp = s.toCharArray();

        int res = 0;
        Map<String, Integer> dics = new HashMap<>();

        for(int k = 0; k < tmp.length; k++){
            for(int l = 0; l < tmp.length - k; l++){
                char[] sub = Arrays.copyOfRange(tmp, l, l + k + 1);
                if(sub.length > 1)
                    Arrays.sort(sub);
                String var = new String(sub);
                if(dics.containsKey(var)) {
                    int cnt = dics.get(var);
                    dics.put(var, cnt + 1);
                } else {
                    dics.put(var, 1);
                }
            }
        }

        // 두 쌍에 대해 nC2(조합 연산) 로 계산
        for(String key : dics.keySet()){
            int num = dics.get(key);
            res += (num - 1) * num / 2;
        }

        return res;
    }

    public static void main(String[] args){
        System.out.println(sherlockAndAnagrams("mom")); // 2
        System.out.println(sherlockAndAnagrams("abba")); // 4
        System.out.println(sherlockAndAnagrams("abcd")); // 0
        System.out.println(sherlockAndAnagrams("ifailuhkqq")); // 3
        System.out.println(sherlockAndAnagrams("kkkk")); // 10
        System.out.println(sherlockAndAnagrams("cdcd")); // 5
    }
}
