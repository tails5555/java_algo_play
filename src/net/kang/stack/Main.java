package net.kang.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 백준 Stack 기초 문제 풀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int k=0;k<N;k++){
            String s = br.readLine();
            if(s.startsWith("push ")){
                stack.push(Integer.parseInt(s.replace("push ", "")));
            } else {
                switch(s){
                    case "top" :
                        bw.append(String.format("%d\n", stack.isEmpty() ? -1 : stack.peek()));
                        break;
                    case "size" :
                        bw.append(String.format("%d\n", stack.size()));
                        break;
                    case "pop" :
                        bw.append(String.format("%d\n", stack.isEmpty() ? -1 : stack.pop()));
                        break;
                    case "empty" :
                        bw.append(String.format("%d\n", stack.isEmpty() ? 1 : 0));
                        break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
