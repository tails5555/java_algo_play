package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// SW Expert D3 모음이 보이지 않는 사람 문제 풀이
public class Main4406 {
    static Set<Character> aeiou = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            String tmp = br.readLine();
            StringBuilder sb = new StringBuilder();
            for(char c : tmp.toCharArray()) {
                if(!aeiou.contains(c))
                    sb.append(c);
            }
            System.out.printf("#%d %s\n", k+1, sb.toString());
        }
    }
}
