package net.programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 프로그래머스 전화번호 목록 문제
public class Lv2PhoneList {
    public static boolean solution(String[] phone_book) {
        Set<String> prefix = new HashSet<>();
        Arrays.sort(phone_book);

        for(int k=0;k<phone_book.length;k++){
            for(String tmp : prefix) {
                if(phone_book[k].startsWith(tmp)) return false;
            }
            prefix.add(phone_book[k]);
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(solution(new String[] { "119", "97674223", "1195456456" }));
        System.out.println(solution(new String[] { "123", "456", "789" }));
        System.out.println(solution(new String[] { "12", "123", "1235", "567", "88" }));
    }
}
