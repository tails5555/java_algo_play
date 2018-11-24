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

// Baekjoon 1167 번 트리의 지름 문제 풀이
// 1번 순환이 완료 된 후에 왜 최댓값인 경우에 한 번 더 순회를 해야 할까... 의문이 듭니다...
public class Main1167 {
    static class Edge {
        int end;
        int length;

        public Edge(int end, int length){
            this.end = end;
            this.length = length;
        }
    }

    public static int[] bfs(Map<Integer, List<Edge>> tree, int vtx, int start){
        int[] lens = new int[vtx + 1];
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        bfs.add(start);
        visited.add(start);
        while(!bfs.isEmpty()){
            int tmp = bfs.poll();
            for(Edge edge : tree.get(tmp)){
                if(!visited.contains(edge.end)){
                    lens[edge.end] += lens[tmp] + edge.length;
                    visited.add(edge.end);
                    bfs.offer(edge.end);
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

        StringTokenizer st;
        for(int k=0;k<N;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int sV = Integer.parseInt(st.nextToken());
            while(true){
                int eV = Integer.parseInt(st.nextToken());
                if(eV == -1) break;
                int len = Integer.parseInt(st.nextToken());
                List<Edge> tmpList = tree.get(sV);
                tmpList.add(new Edge(eV, len));
                tree.put(sV, tmpList);
            }
        }

        int[] dists = bfs(tree, N, 1);
        int result = Integer.MIN_VALUE;
        int tmpIdx = -1;
        for(int k=1;k<=N;k++){
            if(result < dists[k]) {
                result = dists[k];
                tmpIdx = k;
            }
        }

        dists = bfs(tree, N, tmpIdx);
        result = Integer.MIN_VALUE;
        for(int k=1;k<=N;k++){
            result = Math.max(result, dists[k]);
        }

        System.out.println(result);
    }
}
