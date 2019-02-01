package net.programmers;

import java.util.Arrays;

// Programmers 정렬 응용 문제(K 번째 수)
public class Lv2KNumber {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int k=0;k<commands.length;k++){
            int[] arr = Arrays.copyOfRange(array, commands[k][0] - 1, commands[k][1]);
            Arrays.sort(arr);
            answer[k] = arr[commands[k][2] - 1];
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(
            solution(
                new int[] { 1, 5, 2, 6, 3, 7, 4 }, new int[][] {
                    { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 }
                }
            )
        ));
    }
}
