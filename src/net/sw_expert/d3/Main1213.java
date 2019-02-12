package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 String 문제 풀이
public class Main1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k = 0; k < 10; k++){
            int test = Integer.parseInt(br.readLine());
            String pattern = br.readLine();
            String str = br.readLine();
            String tmp = str.replace(pattern, "");
            int cnt = (str.length() - tmp.length()) / pattern.length();
            System.out.printf("#%d %d\n", test, cnt);
        }
    }
}
