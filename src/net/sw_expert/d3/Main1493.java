package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 수의 새로운 연산 문제 풀이
public class Main1493 {
    public static int[] findIdxByGuess(int guess) {
        int x = 1;
        int y = 0;
        int tmp = 1;
        while(true) {
            tmp += y;
            if(tmp > guess) break;
            y += 1;
        }
        tmp -= y;
        x += Math.abs(guess - tmp);
        y -= Math.abs(guess - tmp);

        return new int[] { x, y };
    }

    public static int findGuessByIdx(int[] idx){
        int total = idx[0] + idx[1];

        int y = total - 1;
        int tmp = 1;
        for(int k = 2; k <= y; k++){
            tmp += (k - 1);
        }

        return tmp + idx[0] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] aIdx = findIdxByGuess(a);
            int[] bIdx = findIdxByGuess(b);
            System.out.printf("#%d %d\n", k+1, findGuessByIdx(new int[] { aIdx[0] + bIdx[0], aIdx[1] + bIdx[1] }));
        }
    }
}

// #(1 1) 1
// #(1 2) 2, #(2 1) 3
// #(1 3) 4, #(2 2) 5, #(3 1) 6
// #(1 4) 7, #(2 3) 8, #(3 2) 9, #(4 1) 10
// #(1 5) 11, ...