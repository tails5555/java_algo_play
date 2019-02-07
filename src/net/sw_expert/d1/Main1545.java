package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 삼성 SW Expert D1 거꾸로 출력해 보아요 문제
public class Main1545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int k=0;k<=N;k++){
            stack.add(k);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            int tmp = stack.pop();
            sb.append(String.format("%d ", tmp));
        }
        System.out.println(sb.toString());
    }
}
