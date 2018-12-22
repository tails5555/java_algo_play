package net.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 1753 번 문제 풀이
// 풀었다고 가정합시다.
public class Main1753 {
    static int MAX_WEIGHT = 3000001;
    static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge){
            if(this.weight > edge.weight) return 1;
            else if(this.weight < edge.weight) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dist = new int[N+1];
        PriorityQueue<Edge>[] graph = new PriorityQueue[N+1];

        for(int k=1;k<=N;k++){
            dist[k] = MAX_WEIGHT;
            graph[k] = new PriorityQueue<>();
        }

        int S = Integer.parseInt(br.readLine());

        for(int k=0;k<M;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].offer(new Edge(end, weight));
        }

        Queue<Integer> bfs = new LinkedList<>();
        dist[S] = 0;
        bfs.offer(S);

        while(!bfs.isEmpty()){
            int vtx = bfs.poll();
            Iterator<Edge> iter = graph[vtx].iterator();
            while(iter.hasNext()){
                Edge next = iter.next();
                int nextIdx = next.to;
                int nextWeight = next.weight;
                if(dist[nextIdx] > dist[vtx] + nextWeight){
                    bfs.offer(nextIdx);
                }
                dist[nextIdx] = Math.min(dist[vtx] + nextWeight, dist[nextIdx]);
            }
        }

        for(int k=1;k<=N;k++){
            if(dist[k] == MAX_WEIGHT) bw.write("INF");
            else bw.write(String.valueOf(dist[k]));
            bw.write("\n");
        }

        bw.flush();
    }
}
