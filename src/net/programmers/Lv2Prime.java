package net.programmers;

import java.util.HashSet;
import java.util.Set;

public class Lv2Prime {
    static Set<Integer> set;

    public static boolean isPrime(int n){
        if(n <= 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        for(int k = 3; k*k <= n;k++){
            if(n % k == 0) return false;
        }
        return true;
    }

    public static void permulation(String s, String number){
        if(number.length() == 0) {
            if(!s.equals("")){
                int tmp = Integer.parseInt(s);
                if(isPrime(tmp)){
                    set.add(tmp);
                }
            }
        } else {
            for(int k=0;k<number.length();k++){
                permulation(s + number.charAt(k), number.substring(0, k) + number.substring(k + 1, number.length()));
            }
            for(int k=0;k<number.length();k++){
                permulation(s, number.substring(0, k) + number.substring(k + 1, number.length()));
            }
        }
    }

    public static int solution(String numbers){
        set = new HashSet<>();
        permulation("", numbers);
        return set.size();
    }

    public static void main(String[] args){
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
}
