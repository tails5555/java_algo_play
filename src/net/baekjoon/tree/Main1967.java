package net.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// Baekjoon 1967번 문제 풀이
public class Main1967 {
    static class Edge {
        int end;
        int length;

        public Edge(int end, int length){
            this.end = end;
            this.length = length;
        }

        @Override
        public String toString(){
            return String.format("[%d %d]", this.end, this.length);
        }
    }

    public static int[] bfs(int N, int start, Map<Integer, List<Edge>> tree){
        int[] lens = new int[N+1];
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        bfs.offer(start);
        visited.add(start);
        while (!bfs.isEmpty()) {
            int tmpVtx = bfs.poll();
            for (Edge e : tree.get(tmpVtx)) {
                if (!visited.contains(e.end)) {
                    lens[e.end] += Math.max(lens[tmpVtx] + e.length, lens[e.end]);
                    visited.add(e.end);
                    bfs.offer(e.end);
                }
            }
        }
        return lens;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Edge>> tree = new HashMap<>();
        for(int k=1;k<=N;k++){
            tree.put(k, new ArrayList<Edge>());
        }
        for(int k=1;k<=N-1;k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            List<Edge> tmpStartEdges = tree.get(start);
            List<Edge> tmpEndEdges = tree.get(end);
            tmpStartEdges.add(new Edge(end, len));
            tmpEndEdges.add(new Edge(start, len));
        }

        int result = Integer.MIN_VALUE;
        int[] firstLens = bfs(N, 1, tree);
        int idx = -1;
        for(int k=1;k<=N;k++) {
            if(result < firstLens[k]){
                result = firstLens[k];
                idx = k;
            }
        }
        int[] secondLens = bfs(N, idx, tree);
        for(int k=1;k<=N;k++){
            result = Math.max(result, secondLens[k]);
        }
        System.out.println(result);
    }
}
