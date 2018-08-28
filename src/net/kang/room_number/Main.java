package net.kang.room_number;

import java.util.Scanner;

// 백준 1475 번 문제 풀이
public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String num = s.next();
        char[] nums = num.toCharArray();
        double[] counting = new double[9];
        for(char c : nums){
            if(c != '6' && c != '9')
                counting[c - '0'] += 1;
            else
                counting[6] += 0.5;
        }
        double result = Double.MIN_VALUE;
        for(double c : counting){
            if(result < Math.ceil(c)) result = Math.ceil(c);
        }
        System.out.println((int) result);
    }
}
