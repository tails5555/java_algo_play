package net.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lv1Exam {
    static final int[] primary = { 1, 2, 3, 4, 5 };
    static final int[] secondary = { 2, 1, 2, 3, 2, 4, 2, 5 };
    static final int[] tertiary = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

    public static int[] solution(int[] answers){
        int[] scores = new int[3];
        for(int k=0;k<answers.length;k++){
            scores[0] += answers[k] == primary[k % primary.length] ? 1 : 0;
            scores[1] += answers[k] == secondary[k % secondary.length] ? 1 : 0;
            scores[2] += answers[k] == tertiary[k % tertiary.length] ? 1 : 0;
        }

        int max = Integer.max(scores[0], Integer.max(scores[1], scores[2]));
        List<Integer> list = new ArrayList<>();
        for(int k=0;k<scores.length;k++){
            if(max == scores[k]) list.add(k + 1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 4, 5 })));
        System.out.println(Arrays.toString(solution(new int[] { 1, 3, 2, 4, 2 })));
    }
}
