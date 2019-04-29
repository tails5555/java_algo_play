package net.kakao_code.festival_2018_1st;

import java.util.Scanner;

public class Example01 {
    public static int getAPrice(int A){
        if(A == 1)
            return 5000000;
        else if(A >= 2 && A <= 3)
            return 3000000;
        else if(A >= 4 && A <= 6)
            return 2000000;
        else if(A >= 7 && A <= 10)
            return 500000;
        else if(A >= 11 && A <= 15)
            return 300000;
        else if(A >= 16 && A <= 21)
            return 100000;
        else
            return 0;
    }
    public static int getBPrice(int B){
        if(B == 1)
            return 5120000;
        else if(B >= 2 && B <= 3)
            return 2560000;
        else if(B >= 4 && B <= 7)
            return 1280000;
        else if(B >= 8 && B <= 15)
            return 640000;
        else if(B >= 16 && B <= 31)
            return 320000;
        else
            return 0;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<T;k++) {
            int A = s.nextInt();
            int B = s.nextInt();
            if(k != T-1)
                sb.append(String.format("%d\n", getAPrice(A)+getBPrice(B)));
            else
                sb.append(String.format("%d", getAPrice(A)+getBPrice(B)));
        }
        System.out.println(sb.toString());
    }
}
