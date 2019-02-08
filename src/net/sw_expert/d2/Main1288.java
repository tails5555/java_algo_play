package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// SW Expert D2 새로운 불면증 치료법 문제
public class Main1288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            Set<Character> set = new HashSet<>();
            int x = 1;
            int N = Integer.parseInt(br.readLine());
            while(true) {
                int tmp = x * N;
                char[] str = String.valueOf(tmp).toCharArray();
                for(char c : str) {
                    if(!set.contains(c))
                        set.add(c);
                }
                if(set.size() == 10) break;
                x += 1;
            }
            System.out.printf("#%d %d\n", k+1, x * N);
        }
    }
}
