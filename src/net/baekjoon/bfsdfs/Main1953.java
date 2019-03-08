package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// Baekjoon 1953번 문제
// 팀 나누기
public class Main1953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer>[] graph = new Set[N + 1];
        for(int k = 1; k <= N; k++){
            graph[k] = new HashSet<>();
        }

        StringTokenizer st;
        for(int k = 1; k <= N; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int idx = 0;
            while(idx < M){
                int hater = Integer.parseInt(st.nextToken());
                graph[k].add(hater);
                graph[hater].add(k);
                idx += 1;
            }
        }

        int[] visited = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for(int k = 1; k <= N; k++){
            if(visited[k] == 0){
                visited[k] = 1;
                queue.offer(k);
                while(!queue.isEmpty()){
                    int tmp = queue.poll();
                    for(int a : graph[tmp]){
                        if(visited[a] == 0){
                            queue.offer(a);
                            visited[a] = (-1) * visited[tmp];
                        }
                    }
                }
            }
        }

        int blue = 0, white = 0;
        StringBuilder blueList = new StringBuilder();
        StringBuilder whiteList = new StringBuilder();
        for(int k = 1; k <= N; k++){
            if(visited[k] > 0) {
                blue += 1;
                blueList.append(String.format("%d ", k));
            } else {
                white += 1;
                whiteList.append(String.format("%d ", k));
            }
        }

        System.out.println(blue);
        System.out.println(blueList.toString());
        System.out.println(white);
        System.out.println(whiteList.toString());
    }
}
