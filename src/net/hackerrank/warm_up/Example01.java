package net.hackerrank.warm_up;

import java.util.HashSet;
import java.util.Set;

// Hacker Rank Warm Up 문제
// Sock Merchant(양말 장사 문제)
public class Example01 {
    static int sockMerchant(int n, int[] ar) {
        int res = 0;
        int[] single = new int[101];
        Set<Integer> set = new HashSet<>();
        for(int k=0;k<n;k++){
            single[ar[k]] += 1;
            set.add(ar[k]);
        }
        for(int sock : set) {
            res += single[sock] / 2;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(sockMerchant(7, new int[] { 1, 2, 1, 2, 1, 3, 2 }));
        System.out.println(sockMerchant(9, new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 }));
    }
}
