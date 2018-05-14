package net.kang.hidden_number;

import java.util.Scanner;

// Baekjoon 8575번 문제 풀이
public class Main {
    static Scanner s=new Scanner(System.in);
    static int N;
    static String word;
    static long res;
    public static void input(){
        N = s.nextInt();
        word = s.next();
    }
    public static void solution(){
        StringBuilder num = new StringBuilder();
        for(int k=0;k<N;k++){
            if(!Character.isAlphabetic(word.charAt(k))){
                num.append(word.charAt(k)-'0');
                if((k+1 != N) ? Character.isAlphabetic(word.charAt(k+1)) : true) {
                    res += Integer.parseInt(new String(num));
                    num = new StringBuilder();
                }
            }
        }
    }
    public static void main(String[] args){
        input();
        solution();
        System.out.println(res);
    }
}
