package net.baekjoon.implement;

import java.util.Scanner;

public class Main15667 {
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
