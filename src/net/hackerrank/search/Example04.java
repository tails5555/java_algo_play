package net.hackerrank.search;

import java.util.Arrays;

// Hacker Rank 탐색 문제
// Triple Sum 문제
public class Example04 {
    static long triplets(int[] a, int[] b, int[] c) {
        int[] tmp_a = Arrays.stream(a).sorted().distinct().toArray();
        int[] tmp_b = Arrays.stream(b).sorted().distinct().toArray();
        int[] tmp_c = Arrays.stream(c).sorted().distinct().toArray();

        int idx = 0;
        int aIdx = 0;
        int cIdx = 0;

        long answer = 0L;
        while(idx < tmp_b.length) {
            while(aIdx < tmp_a.length && tmp_b[idx] >= tmp_a[aIdx]){
                aIdx += 1;
            }

            while(cIdx < tmp_c.length && tmp_b[idx] >= tmp_c[cIdx]){
                cIdx += 1;
            }

            answer += ((long) aIdx * (long) cIdx);
            idx += 1;
        }

        return answer;
    }

    public static void main(String[] args){
        System.out.println(triplets(
            new int[] { 3, 5, 7 }, new int[] { 3, 6 }, new int[] { 4, 6, 9 }
        ));
        System.out.println(triplets(
            new int[] { 1, 3, 5 }, new int[] { 2, 3 }, new int[] { 1, 2, 3 }
        ));
        System.out.println(triplets(
            new int[] { 1, 4, 5 }, new int[] { 2, 3, 3 }, new int[] { 1, 2, 3 }
        ));
        System.out.println(triplets(
            new int[] { 1, 3, 5, 7 }, new int[] { 5, 7, 9 }, new int[] { 7, 9, 11, 13 }
        ));
    }
}
