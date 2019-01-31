package net.baekjoon.topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Baekjoon 1766번 문제 풀이
public class Main1766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer>[] map = new PriorityQueue[N + 1];
        for(int k = 1; k <= N; k++){
            map[k] = new PriorityQueue<>();
        }

        int[] dist = new int[N + 1];
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start].offer(end);
            dist[end] += 1;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int k = 1; k <= N; k++) {
            if(dist[k] == 0)
                queue.add(k);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            sb.append(String.format("%d ", tmp));
            PriorityQueue<Integer> direct = map[tmp];
            while(!direct.isEmpty()) {
                int v = direct.poll();
                dist[v] -= 1;
                if(dist[v] == 0)
                    queue.offer(v);
            }
        }

        System.out.println(sb.toString());
    }
}
