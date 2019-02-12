package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// SW Expert D3 회문 퍼즐 최댓값 찾기 문제 풀이
public class Main1216 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int k = 0; k < 10; k++){
            int test = Integer.parseInt(br.readLine());
            char[][] puzzle = new char[100][100];
            for(int l = 0; l < 100; l++){
                puzzle[l] = br.readLine().toCharArray();
            }

            int cnt = 1;
            int start, end, mid;
            Stack<Character> stack;
            for(int l = 0; l < 200; l++){
                for(int m = 1; m <= 100; m++) {
                    for (int n = 0; n <= 100 - m; n++) {
                        start = n;
                        end = n + m - 1;
                        mid = (start + end) / 2;
                        stack = new Stack<>();
                        for (int o = start; o <= mid; o++) {
                            if (l / 100 >= 1) {
                                stack.push(puzzle[o][l % 100]);
                            } else {
                                stack.push(puzzle[l % 100][o]);
                            }
                        }

                        boolean isPalindrome = true;
                        if (m % 2 != 0) {
                            stack.pop();
                        }
                        int idx = mid + 1;
                        while (!stack.isEmpty()) {
                            char cur = stack.pop();
                            if (l / 100 >= 1) {
                                if (cur != puzzle[idx++][l % 100]) {
                                    isPalindrome = false;
                                    break;
                                }
                            } else {
                                if (cur != puzzle[l % 100][idx++]) {
                                    isPalindrome = false;
                                    break;
                                }
                            }
                        }

                        if (isPalindrome) {
                            cnt = Math.max(cnt, m);
                        }
                    }
                }
            }

            System.out.printf("#%d %d\n", test, cnt);
        }
    }
}
