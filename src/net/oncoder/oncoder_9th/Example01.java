package net.oncoder.oncoder_9th;

import java.util.Arrays;

// 온코더 9회 공식테스트 1번
public class Example01 {
    public static int[] solution(int T, int[] requiredTime){
        int[] tmp = requiredTime;
        Arrays.sort(tmp);
        int cnt = 0;
        int negative = 0;
        int sum = 0;
        for(int k = 0; k < tmp.length; k++){
            sum += tmp[k];
            if(sum > T) break;
            if(tmp[k] <= T) {
                cnt += 1;
                negative += sum;
            }
        }
        return new int[]{ cnt, negative };
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(74, new int[] { 47 })));
        System.out.println(Arrays.toString(solution(74, new int[] { 4747 })));
        System.out.println(Arrays.toString(solution(47, new int[] { 8, 5 })));
        System.out.println(Arrays.toString(solution(47, new int[] { 12, 3, 21, 6, 4, 13 })));
        System.out.println(Arrays.toString(solution(58, new int[] { 4, 5, 82, 3, 4, 65, 7, 6, 8, 7, 6, 4, 8, 7, 6, 37, 8 })));
        System.out.println(Arrays.toString(solution(100000, new int[] { 100000 })));
    }
}
