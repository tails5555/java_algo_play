package net.programmers;

import java.util.Arrays;

// Programmers 정렬 응용 문제(가장 큰 수)
// 풀이 참조...ㅜ
public class Lv2BetterNumber {
    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] num = new String[numbers.length];

        for(int k=0;k<num.length;k++){
            num[k] = String.valueOf(numbers[k]);
        }
        Arrays.sort(num, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if(num[0].equals("0"))
            sb.append("0");
        else
            for(int k=0;k<num.length;k++){
                sb.append(num[k]);
            }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] { 6, 10, 2 }));
        System.out.println(solution(new int[] { 3, 30, 34, 5, 9 }));
    }
}
