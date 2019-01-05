package net.programmers;

public class Lv3Country124 {
    static char[] alphabet = { '4', '1', '2' };
    public static String solution(int N) {
        String st = "";
        int a;
        while(N > 0) {
            a = N % 3;
            N = N / 3;
            if (a == 0)
                N -= 1;
            st = alphabet[a] + st;
        }
        return st;
    }

    public static void main(String[] args){
        for(int k=1;k<=20;k++) {
            System.out.println(solution(k));
        }
    }
}
