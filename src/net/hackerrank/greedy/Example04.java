package net.hackerrank.greedy;

import java.util.Arrays;

// Hacker Rank 탐욕 알고리즘 문제
// Max Min 문제 (온갖 자료구조 다 쓰는 문제인 줄 알았으나, 처음에 생각한 거로 해도 상관 없었음 ㅜㅜ 어렵게 생각하는 것도 적당히 해야 하는 좋은 문제)
public class Example04 {
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int diff = arr[arr.length - 1] - arr[0];
        for(int i = 0; i < arr.length - k + 1; i++){
            diff = Math.min(diff, arr[i + k - 1] - arr[i]);
        }
        return diff;
    }

    public static void main(String[] args){
        System.out.println(maxMin(3, new int[] { 10, 100, 300, 200, 1000, 20, 30 }));
        System.out.println(maxMin(4, new int[] { 1, 2, 3, 4, 10, 20, 30, 40, 100, 200 }));
        System.out.println(maxMin(2, new int[] { 1, 2, 1, 2, 1 }));
        System.out.println(maxMin(3, new int[] { 1, 2, 1, 2, 1 }));
        System.out.println(maxMin(4, new int[] { 1, 2, 1, 2, 1 }));
        System.out.println(maxMin(3, new int[] { 2, 1, 2, 1, 2 }));
        System.out.println(maxMin(2, new int[] { 1, 4, 7, 2 }));
    }
}
