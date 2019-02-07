package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 삼성 SW Expert D1 신문 헤드라인 문제 풀이
public class Main2047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        for(int k=0;k<s.length;k++){
            if(s[k] >= 'a' && s[k] <= 'z') {
                s[k] = (char) ('A' + (s[k] - 'a'));
            }
        }
        String tmp = new String(s);
        System.out.println(tmp);
    }
}
