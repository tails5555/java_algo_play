package net.programmers;

import java.util.Arrays;

public class Lv2Stock {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int k = 0; k < prices.length - 1; k++){
            for(int l = k; l < prices.length - 1; l++){
                if(prices[k] > prices[l]) break;
                else answer[k] += 1;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(new int[] { 498, 501, 470, 489 })));
    }
}
