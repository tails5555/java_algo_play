package net.baekjoon.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 백준 1260번 문제 풀이
public class Main1260 {
    public static void dfs(boolean[][] map, boolean[] visited, int vertex){
        System.out.printf("%d ", vertex);
        visited[vertex] = true;
        for(int k=1;k<=map.length-1;k++){
            if(!visited[k] && map[vertex][k] == true){
                dfs(map, visited, k);
            }
        }
    }
    public static void bfs(boolean[][] map, int vertex){
        boolean[] visited = new boolean[map.length];
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(vertex);
        visited[vertex]=true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            System.out.printf("%d ", tmp);
            for(int k=1;k<=map.length-1;k++){
                if(map[tmp][k] == true && !visited[k]){
                    q.offer(k);
                    visited[k] = true;
                    map[tmp][k] = false;
                    map[k][tmp] = false;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        boolean[][] map1 = new boolean[N+1][N+1];
        boolean[][] map2 = new boolean[N+1][N+1];
        int M = s.nextInt();
        int V = s.nextInt();
        for(int k=0;k<M;k++){
            int start = s.nextInt();
            int end = s.nextInt();

            map1[start][end] = true;
            map1[end][start] = true;

            map2[start][end] = true;
            map2[end][start] = true;
        }

        dfs(map1, new boolean[N+1], V);
        System.out.println();
        bfs(map2, V);
    }
}
