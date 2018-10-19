package net.baekjoon.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 백준 14699번 문제 풀이
// 참고로 2017 서울대 프로그래밍 문제 중 위상 정렬을 이용하여 풀 수 있는 문제 복습.
public class Main14699 {
    static class Graph{
        int vtx;
        List<Integer> next;
        public Graph(int vtx){
            this.vtx=vtx;
            this.next=new ArrayList<Integer>();
        }
        public void addNext(int nextVtx){
            next.add(nextVtx);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int[] height = new int[V + 1];
        int[] in = new int[V + 1];
        Graph[] graph = new Graph[V + 1];
        for (int k = 1; k <= V; k++) {
            height[k] = s.nextInt();
            graph[k] = new Graph(k);
        }
        for (int k = 0; k < E; k++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            if (height[v1] < height[v2]) {
                int tmp = v1;
                v1 = v2;
                v2 = tmp;
            }
            graph[v1].addNext(v2);
            in[v2]++;
        }

        Queue<Graph> queue = new LinkedList<Graph>();
        int[] result = new int[V+1];
        for(int k=1;k<in.length;k++){
            if(in[k]==0) queue.add(graph[k]);
        }
        while(!queue.isEmpty()){
            Graph cur = queue.poll();
            for(int k : cur.next){
                result[k] = Math.max(result[k], result[cur.vtx]+1);
                in[k]--;
                if(in[k] == 0) queue.offer(graph[k]);
            }
        }

        for(int k=1;k<=V;k++){
            System.out.println(result[k]+1);
        }
    }
}
