package net.baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// Baekjoon 5567번 결혼식 문제 풀이
public class Main5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][] graph = new boolean[N+1][N+1];
        StringTokenizer st;
        for(int k=0;k<M;k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            graph[f1][f2] = graph[f2][f1] = true;
        }

        Set<Integer> friends = new HashSet<>();
        for(int k=2;k<=N;k++){
            if(graph[1][k] && graph[k][1])
                friends.add(k);
        }

        List<Integer> list = friends.stream().collect(Collectors.toList());
        for(int k : list){
            for(int l=2;l<=N;l++){
                if(graph[k][l] && graph[l][k])
                    friends.add(l);
            }
        }

        System.out.println(friends.size());
    }
}
