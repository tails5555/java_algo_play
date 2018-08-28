package net.kang.deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

// 백준 Deque 기초 문제 풀이
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();
        for(int k=0;k<N;k++){
            String s = br.readLine();
            if(s.startsWith("push_front ")){
                deque.addFirst(Integer.parseInt(s.replace("push_front ", "")));
            } else if(s.startsWith("push_back ")){
                deque.addLast(Integer.parseInt(s.replace("push_back ", "")));
            } else {
                switch(s){
                    case "front" :
                        bw.append(String.format("%d\n", deque.isEmpty() ? -1 : deque.peekFirst()));
                        break;
                    case "back" :
                        bw.append(String.format("%d\n", deque.isEmpty() ? -1 : deque.peekLast()));
                        break;
                    case "size" :
                        bw.append(String.format("%d\n", deque.size()));
                        break;
                    case "pop_front" :
                        bw.append(String.format("%d\n", deque.isEmpty() ? -1 : deque.removeFirst()));
                        break;
                    case "pop_back" :
                        bw.append(String.format("%d\n", deque.isEmpty() ? -1 : deque.removeLast()));
                        break;
                    case "empty" :
                        bw.append(String.format("%d\n", deque.isEmpty() ? 1 : 0));
                        break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
