package net.baekjoon.stack_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 1725번 히스토그램 풀이
public class Main1725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        int[] histogram = new int[N + 2];
        while(idx != N + 1)
            histogram[idx++] = Integer.parseInt(br.readLine());

        int ans = 0;
        stack.push(0);
        for(int k = 1; k <= N + 1; k++){
            while(!stack.isEmpty() && histogram[stack.peek()] > histogram[k]){
                int tmpIdx = stack.pop();
                ans = Math.max(ans, (k - stack.peek() - 1) * histogram[tmpIdx]);
            }
            stack.push(k);
        }
        System.out.println(ans);
    }
}
