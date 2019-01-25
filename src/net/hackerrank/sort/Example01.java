package net.hackerrank.sort;

import java.util.Arrays;

// Hacker Rank Sorting 문제
// Bubble Sort Question
public class Example01 {
    static void countSwaps(int[] a) {
        int[] sortArr;
        sortArr = Arrays.copyOf(a, a.length);
        Arrays.sort(sortArr);

        int cnt = 0;
        for(int k = 0; k < a.length; k++){
            if(Arrays.equals(sortArr, a)) break;
            for(int l = 0; l < a.length - 1; l++){
                if(a[l] > a[l + 1]){
                    int tmp = a[l];
                    a[l] = a[l + 1];
                    a[l + 1] = tmp;
                    cnt += 1;
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.\n", cnt);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d\n", a[a.length - 1]);
    }

    public static void main(String[] args){
        countSwaps(new int[] { 1, 2, 3 });
        countSwaps(new int[] { 3, 2, 1 });
        countSwaps(new int[] { 6, 4, 1 });
        countSwaps(new int[] { 9, 4, 5, 3, 1 });
    }
}
