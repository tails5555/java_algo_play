package net.baekjoon.topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 줄 세우기 문제
public class Main2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] map = new LinkedList[N + 1];
        for(int k=1;k<=N;k++){
            map[k] = new LinkedList<>();
        }

        int[] dist = new int[N + 1];
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start].addFirst(end);
            dist[end] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int k = 1; k <= N; k++){
            if(dist[k] == 0) queue.offer(k);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            sb.append(String.format("%d ", tmp));

            for(int k : map[tmp]) {
                dist[k] -= 1;
                if(dist[k] == 0){
                    queue.offer(k);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
