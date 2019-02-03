package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// Baekjoon 6118 번 문제 풀이
public class Main6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int k=0;k<M;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Set<Integer> startSet = map.getOrDefault(start, new HashSet<>());
            startSet.add(end);
            Set<Integer> endSet = map.getOrDefault(end, new HashSet<>());
            endSet.add(start);

            map.put(start, startSet);
            map.put(end, endSet);
        }

        dist[1] = 0;
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int max = 0;
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            for(int vtx : map.getOrDefault(tmp, new HashSet<>())) {
                if(!visited[vtx]) {
                    queue.offer(vtx);
                    visited[vtx] = true;
                    dist[vtx] = Math.min(dist[vtx], dist[tmp] + 1);
                    max = Math.max(max, dist[vtx]);
                }
            }
        }

        int cnt = 0;
        int idx = -1;
        for(int k = 1; k <= N; k++){
            if(idx == -1) {
                if(max == dist[k]) {
                    idx = k;
                }
            }
            if(max == dist[k]) {
                cnt += 1;
            }
        }

        System.out.printf("%d %d %d\n", idx, max, cnt);
    }
}
