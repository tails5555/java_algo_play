package net.hackerrank.array;

import java.util.Arrays;

// Hacker Rank Array 문제
// 2번. Left Rotation 문제
public class Example02 {
    static int[] rotLeft(int[] a, int d) {
        if(d == a.length) return a;
        int[] tmp = new int[a.length];
        int idx = 0;
        tmp[idx++] = a[d];
        for(int k = (d + 1) % a.length; k != d; k = (k + 1) % a.length){
            tmp[idx++] = a[k];
        }
        return tmp;
    }

    public static void main(String[] args){
        int[] tmp = rotLeft(new int[] { 1, 2, 3, 4, 5 }, 4);
        System.out.println(Arrays.toString(tmp));
    }
}
