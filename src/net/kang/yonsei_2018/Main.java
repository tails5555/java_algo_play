package net.kang.yonsei_2018;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args){
        int N = s.nextInt();
        int a = 0;
        for(int k=1;k<=N;k++){
            if(N-1 == k * (k+1)) {
                a = k;
                break;
            }
        }
        System.out.println(a);
    }
}
