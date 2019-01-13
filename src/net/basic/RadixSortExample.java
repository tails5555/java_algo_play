package net.basic;

import java.util.Arrays;
import java.util.Random;

public class RadixSortExample {
    public static int max_exponent(int[] arr, int not){
        int max_expo = Integer.MIN_VALUE;
        for(int k=0;k<arr.length;k++){
            max_expo = Math.max(max_expo, (int)(Math.log10(arr[k]) / Math.log10(not)));
        }
        return max_expo;
    }

    public static void radixSort(int[] arr, int expo, int not){
        if(arr.length <= 1) return;

        int[] count = new int[not];
        int[] temp = new int[arr.length];

        int pivot, idx;
        for(int k=0;k<=expo+1;k++){
            for(int l=0;l<not;l++) count[l] = 0;

            pivot = (int) Math.pow((double) not, (double) k);
            for(int l=0;l<arr.length;l++){
                idx = (arr[l] / pivot) % not;
                count[idx] += 1;
            }

            for(int l=1;l<not;l++){
                count[l] += count[l - 1];
            }

            for(int l=arr.length - 1;l>=0;l--){
                idx = (arr[l] / pivot) % not;
                temp[count[idx] - 1] = arr[l];
                count[idx] -= 1;
            }

            arr = Arrays.copyOf(temp, temp.length);
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void main(String[] args){
        Random random = new Random();

        int size = 1 + random.nextInt(30);

        int[] arr = new int[size];
        for(int k=0;k<size;k++){
            arr[k] = random.nextInt(1000000) + 1;
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(max_exponent(arr, 10));
        radixSort(arr, max_exponent(arr, 10), 10);
    }
}
