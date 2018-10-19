package net.baekjoon.ds_basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

// 백준 큐 기초 문제 풀이
public class Main10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        for(int k=0;k<N;k++){
            String s = br.readLine();
            if(s.startsWith("push ")){
                queue.offer(Integer.parseInt(s.replace("push ", "")));
            } else {
                switch(s){
                    case "front" :
                        bw.append(String.format("%d\n", queue.isEmpty() ? -1 : queue.peekFirst()));
                        break;
                    case "back" :
                        bw.append(String.format("%d\n", queue.isEmpty() ? -1 : queue.peekLast()));
                        break;
                    case "size" :
                        bw.append(String.format("%d\n", queue.size()));
                        break;
                    case "pop" :
                        bw.append(String.format("%d\n", queue.isEmpty() ? -1 : queue.removeFirst()));
                        break;
                    case "empty" :
                        bw.append(String.format("%d\n", queue.isEmpty() ? 1 : 0));
                        break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
