package net.hackerrank.search;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

// Hacker Rank 탐색 문제
// Pairs 문제
// 숫자 안에서 2개의 데이터를 뽑아 그 차이에 해당되는 쌍을 출력하는 문제
public class Example03 {
    static int pairs(int k, int[] arr) {
        Set<Integer> set = new TreeSet<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        int cnt = 0;
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i] + k)) cnt += 1;
        }
        return cnt;
    }
    public static void main(String[] args){
        System.out.println(pairs(2, new int[] { 1, 5, 3, 4, 2 }));
        System.out.println(pairs(1, new int[] { 1, 2, 3, 4 }));
        System.out.println(pairs(4, new int[] { 1, 3, 5, 7, 9, 13, 17, 18, 19, 20, 21 }));
    }
}
