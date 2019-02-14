package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 홀수일까 짝수일까 문제 풀이
public class Main5549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            String tmp = br.readLine();
            System.out.printf("#%d %s\n", k+1, (tmp.charAt(tmp.length() - 1) - '0') % 2 == 0 ? "Even" : "Odd");
        }
    }
}
