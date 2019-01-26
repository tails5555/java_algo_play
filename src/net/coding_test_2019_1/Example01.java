package net.coding_test_2019_1;

import java.util.Arrays;

// 프로그래머스 2019 상반기 모의고사 문제 No.1
// 배열 회전 문제(100점)
public class Example01 {
    public static boolean solution(int[] arrA, int[] arrB) {
        int[] sortedA = Arrays.copyOf(arrA, arrA.length);
        int[] sortedB = Arrays.copyOf(arrB, arrB.length);

        Arrays.sort(sortedA);
        Arrays.sort(sortedB);

        if(!Arrays.equals(sortedA, sortedB))
            return false;

        int[] rotation = Arrays.copyOf(arrA, arrA.length);

        for(int k = 0; k < arrA.length; k++){
            int[] tmp = new int[arrA.length];
            tmp[0] = rotation[rotation.length - 1];

            System.arraycopy(rotation, 0, tmp, 1, tmp.length - 1);

            if(Arrays.equals(arrB, tmp)) return true;
            rotation = tmp;
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] { 7, 8, 10 }, new int[] { 10, 7, 8 }));
        System.out.println(solution(new int[] { 4, 3, 2, 1 }, new int[] { 5, 4, 1, 2 }));
    }
}
