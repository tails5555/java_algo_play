package net.hackerrank.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Hacker Rank Hash Table 문제
// Frequency Queries 문제
public class Example05 {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(List<Integer> query : queries) {
            int op = query.get(0);
            int num = query.get(1);
            switch(op) {
                case 1 :
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    break;
                case 2 :
                    if(map.containsKey(num)){
                        if(map.get(num) <= 1) map.remove(num);
                        else map.put(num, map.get(num) - 1);
                    }
                    break;
                case 3 :
                    if(map.containsValue(num))
                        res.add(1);
                    else res.add(0);
                    break;
            }
        }

        return res;
    }

    public static void main(String[] args){
        List<List<Integer>> query1 = Arrays.asList(
            Arrays.asList(1, 5), Arrays.asList(1, 6), Arrays.asList(3, 2), Arrays.asList(1, 10), Arrays.asList(1, 10), Arrays.asList(1, 6), Arrays.asList(2, 5), Arrays.asList(3, 2)
        );
        System.out.println(freqQuery(query1));
    }
}
