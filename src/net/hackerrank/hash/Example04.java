package net.hackerrank.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Hacker Rank Hash Table 문제
// Count Triplets 문제(어려웡)
public class Example04 {
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> cntBox1 = new HashMap<>();
        Map<Long, Long> cntBox2 = new HashMap<>();
        long res = 0L;
        for(long v : arr){
            res += cntBox2.getOrDefault(v, 0L);
            if(cntBox1.containsKey(v))
                cntBox2.put(v * r, cntBox2.getOrDefault(v * r, 0L) + cntBox1.get(v));
            cntBox1.put(v * r, cntBox1.getOrDefault(v * r, 0L) + 1);
        }

        return res;
    }

    public static void main(String[] args){
        List<Long> list1 = Arrays.asList(1L, 2L, 2L, 4L);
        System.out.println(countTriplets(list1, 2L));

        List<Long> list2 = Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L);
        System.out.println(countTriplets(list2, 3L));

        List<Long> list3 = Arrays.asList(1L, 5L, 5L, 25L, 125L);
        System.out.println(countTriplets(list3, 5L));
    }
}
