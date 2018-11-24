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

// Baekjoon 11725번 문제 풀이
public class Main11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for(int k=1;k<=N;k++){
            tree.put(k, new ArrayList<Integer>());
        }

        StringTokenizer st;
        for(int k=1;k<=N-1;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int sV = Integer.parseInt(st.nextToken());
            int eV = Integer.parseInt(st.nextToken());
            List<Integer> tmpSList = tree.get(sV);
            List<Integer> tmpEList = tree.get(eV);
            tmpSList.add(eV);
            tmpEList.add(sV);
            tree.put(sV, tmpSList);
            tree.put(eV, tmpEList);
        }

        int[] parents = new int[N+1];
        Queue<Integer> bfs = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        bfs.add(1);
        visited.add(1);
        while(!bfs.isEmpty()) {
            int parent = bfs.poll();
            for(int item : tree.get(parent)) {
                if(!visited.contains(item)) {
                    parents[item] = parent;
                    visited.add(item);
                    bfs.offer(item);
                }
            }
        }

        for(int k=2;k<=N;k++){
            System.out.println(parents[k]);
        }
    }
}
