package net.hackerrank.greedy;

import java.util.Arrays;
import java.util.Collections;

// Hacker Rank 탐욕 알고리즘 문제
// Greedy Florist 문제(저렴한 꽃다발 주문 문제)
// (0 + 1) * 현재가, (1 + 1) * 현재가, (2 + 1) * 현재가 이런 순이었음. 시간 낭비 ㅜㅜ
public class Example03 {
    static int getMinimumCost(int k, int[] c) {
        if(k == c.length){
            return Arrays.stream(c).reduce(0, (o1, o2) -> o1 + o2);
        } else {
            Integer[] tmp = Arrays.stream(c).boxed().toArray(Integer[]::new);
            Arrays.sort(tmp, Collections.reverseOrder());

            int pay = 0;
            int groups = (int) Math.ceil((double) tmp.length / k);
            for(int i = 0; i < groups; i++){
                int start = k * i;
                int end = Math.min(k * (i + 1) - 1, tmp.length - 1);

                for(int j = start; j <= end; j++){
                    pay += (i + 1) * tmp[j];
                }
            }
            return pay;
        }
    }

    public static void main(String[] args){
        System.out.println(getMinimumCost(3, new int[] { 2, 5, 6 }));
        System.out.println(getMinimumCost(2, new int[] { 2, 5, 6 }));
        System.out.println(getMinimumCost(3, new int[] { 1, 3, 5, 7, 9 }));
    }
}
