package net.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 1343 폴리오미노 문제 풀이
public class Main1343 {
    static final String x4 = "XXXX";
    static final String x2 = "XX";
    static final String a4 = "AAAA";
    static final String b2 = "BB";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();

        while(board.contains(x4)) {
            board = board.replaceFirst(x4, a4);
        }

        while(board.contains(x2)) {
            board = board.replaceFirst(x2, b2);
        }

        boolean checked = true;
        for(int k = 0; k < board.length(); k++){
            if(board.charAt(k) == 'X') {
                checked = false;
                break;
            }
        }

        if(checked){
            System.out.println(board);
        } else {
            System.out.println(-1);
        }
    }
}
