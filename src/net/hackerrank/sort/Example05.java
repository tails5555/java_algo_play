package net.hackerrank.sort;

import java.util.Arrays;

// Hacker Rank Sorting 문제
// Merge Sort 에서 몇 번 swap 을 했을까?
public class Example05 {
    static long count;
    static int[] sorted;

    static void mergeSort(int[] a, int start, int end) {
        if (start == end) return;
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle + 1, end);
        merge(a, start, middle, end);
    }

    static void merge(int[] a, int start, int middle, int end) {
        int length = end - start + 1;
        int[] temp = new int[length];

        int i = 0;
        int index1 = start;
        int index2 = middle + 1;

        while (index1 <= middle && index2 <= end) {
            if (a[index1] > a[index2]) {
                temp[i++] = a[index2++];
                count += middle - index1 + 1;
            }
            else
                temp[i++] = a[index1++];
        }
        while (index1 <= middle)
            temp[i++] = a[index1++];
        while (index2 <= end)
            temp[i++] = a[index2++];

        System.arraycopy(temp, 0, a, start, end - start + 1);
    }

    static long countInversions(int[] arr) {
        sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        if(Arrays.equals(sorted, arr)) {
            return 0L;
        }
        count = 0L;
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }

    public static void main(String[] args){
        System.out.println(countInversions(new int[] { 1, 1, 1, 2, 2 }));
        System.out.println(countInversions(new int[] { 2, 1, 3, 1, 2 }));
    }
}
