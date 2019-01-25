package net.hackerrank.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Hacker Rank Hash Table 문제
// Frequency Queries 문제
public class Example05 {
    static List<Integer> freqQuery(int[][] queries) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int k = 0; k < queries.length; k++){
            int op = queries[k][0];
            int num = queries[k][1];
            int tmp_freq;
            switch(op) {
                case 1 :
                    tmp_freq = freq.getOrDefault(num, 0);
                    count.put(tmp_freq, count.getOrDefault(tmp_freq, 0) - 1);
                    freq.put(num, ++tmp_freq);
                    count.put(tmp_freq, count.getOrDefault(tmp_freq, 0) + 1);
                    break;
                case 2 :
                    if(freq.getOrDefault(num, 0) > 0){
                        tmp_freq = freq.getOrDefault(num, 0);
                        count.put(tmp_freq, count.getOrDefault(tmp_freq, 0) - 1);
                        freq.put(num, --tmp_freq);
                        count.put(tmp_freq, count.getOrDefault(tmp_freq, 0) + 1);
                    }
                    break;
                case 3 :
                    if(count.getOrDefault(num, 0) > 0)
                        res.add(1);
                    else res.add(0);
                    break;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[][] query1 = new int[][] {
            { 1, 5 }, { 1, 6 }, { 3, 2 }, { 1, 10 }, { 1, 10 }, { 1, 6 }, { 2, 5 }, { 3, 2 }
        };
        System.out.println(freqQuery(query1));
    }
}
