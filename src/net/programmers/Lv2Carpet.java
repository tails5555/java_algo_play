package net.programmers;

import java.util.Arrays;

public class Lv2Carpet {
    public static int[] solution(int brown, int red){
        int[] res = new int[2];
        for(int k=1;k*k<=red;k++){
            if(red % k == 0) {
                int height = k;
                int width = red / k;
                if((width + height + 2) * 2 == brown) {
                    res[0] = width + 2;
                    res[1] = height + 2;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }
}
