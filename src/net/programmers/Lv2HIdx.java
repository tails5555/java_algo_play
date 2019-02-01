package net.programmers;

import java.util.Arrays;
import java.util.Collections;

// Programmers 정렬 응용 문제(H-Index)
public class Lv2HIdx {
    public static int solution(int[] citations) {
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        int h = 0;
        while(h < tmp.length && tmp[h] >= h + 1)
            h += 1;
        return h;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] { 3, 0, 6, 1, 5 }));
    }
}
