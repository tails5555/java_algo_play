package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// Baekjoon 5214 환승 문제 풀이
public class Main5214 {
    static final int MAX = 10000000;
    static BufferedReader br;
    static StringTokenizer st;
    static List<List<Integer>> graph;
    static int[] dist;
    static int N, K;

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int k = 0; k <= N + K; k++){
            graph.add(new ArrayList<>());
        }

        for(int k = 1; k <= K; k++){
            st = new StringTokenizer(br.readLine());

            int dummy = N + k;
            for(int l = 0; l < n; l++){
                int child = Integer.parseInt(st.nextToken());
                graph.get(dummy).add(child);
                graph.get(child).add(dummy);
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        dist = new int[101005];
        Arrays.fill(dist, MAX);

        dist[1] = 1;
        queue.offer(1);
        visited.add(1);

        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            if(tmp == N) break;
            for(int child : graph.get(tmp)) {
                if(!visited.contains(child) && dist[child] > dist[tmp] + 1){
                    queue.offer(child);
                    visited.add(child);
                    dist[child] = dist[tmp] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        if(dist[N] >= MAX) {
            System.out.println(-1);
        } else {
            System.out.println((dist[N] + 1) / 2);
        }
    }
}
