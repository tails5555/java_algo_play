package net.kang.josepus_0;

// 백준 11866번 문제 풀이
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void solution(int N, int M){
        Deque<Integer> before = new LinkedList<Integer>();
        for(int k=1;k<=N;k++){
            before.offer(k);
        }
        System.out.print("<");
        while(!before.isEmpty()){
            for(int k=0;k<M-1;k++){
                before.addLast(before.poll());
            }
            if(before.size()!=1)
                System.out.print(before.poll()+", ");
            else
                System.out.print(before.poll());
        }
        System.out.println(">");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        solution(N, M);
    }
}
