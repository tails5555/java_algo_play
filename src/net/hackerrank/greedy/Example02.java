package net.hackerrank.greedy;

import java.util.Arrays;

// Hacker Rank 탐욕 알고리즘 문제
// Luck Balance 문제
public class Example02 {
    static int luckBalance(int k, int[][] contests) {
        Arrays.sort(contests, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });

        int luck = 0;
        int imp = (int) Arrays.stream(contests).filter(arr -> arr[1] == 1).count();
        int pivot = imp - k;
        for(int i = 0; i < contests.length; i++){
            if(i >= pivot) {
                luck += contests[i][0];
            } else {
                luck -= contests[i][0];
            }
        }

        return luck;
    }

    public static void main(String[] args){
        System.out.println(luckBalance(1, new int[][] {
            { 5, 1 }, { 1, 1 }, { 4, 0 }
        }));
        System.out.println(luckBalance(2, new int[][] {
            { 5, 1 }, { 1, 1 }, { 4, 0 }
        }));
        System.out.println(luckBalance(3, new int[][] {
            { 5, 1 }, { 2, 1 }, { 1, 1 }, { 8, 1 }, { 10, 0 }, { 5, 0 }
        }));
    }
}
