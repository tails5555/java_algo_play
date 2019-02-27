package net.oncoder.oncoder_10th;

import java.util.Arrays;

// 온코더 10회 공식테스트 1번
public class Example01 {
    public static int solution(int[] marks){
        int sum = Arrays.stream(marks).sum();
        int cnt = marks.length;
        double avg = (double) sum / cnt;
        while(avg < 9.5){
            sum += 10;
            cnt += 1;
            avg = (double) sum / cnt;
        }

        return cnt - marks.length;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[] { 8, 9, 10 }));
        System.out.println(solution(new int[] { 7, 8, 9, 10 }));
    }
}
