package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// SW Expert D3 회문 퍼즐 문제 풀이
public class Main1215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k = 0; k < 10; k++){
            int N = Integer.parseInt(br.readLine());
            char[][] puzzle = new char[8][8];
            for(int l = 0; l < 8; l++){
                puzzle[l] = br.readLine().toCharArray();
            }

            int cnt = 0;
            int start, end, mid;
            Stack<Character> stack;
            for(int l = 0; l < 16; l++){
                for(int m = 0; m <= 8 - N; m++){
                    start = m;
                    end = m + N - 1;
                    mid = (start + end) / 2;
                    stack = new Stack<>();
                    for (int n = start; n <= mid; n++) {
                        if(l / 8 >= 1) {
                            stack.push(puzzle[n][l % 8]);
                        } else {
                            stack.push(puzzle[l % 8][n]);
                        }
                    }

                    boolean isPalindrome = true;
                    if(N % 2 != 0) {
                        stack.pop();
                    }
                    int idx = mid + 1;
                    while(!stack.isEmpty()){
                        char cur = stack.pop();
                        if(l / 8 >= 1) {
                            if (cur != puzzle[idx++][l % 8]) {
                                isPalindrome = false;
                                break;
                            }
                        } else {
                            if (cur != puzzle[l % 8][idx++]) {
                                isPalindrome = false;
                                break;
                            }
                        }
                    }

                    if(isPalindrome) {
                        cnt += 1;
                    }
                }
            }

            System.out.printf("#%d %d\n", k+1, cnt);
        }
    }
}
