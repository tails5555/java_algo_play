package net.baekjoon.dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1719 {
    static int MAX_WEIGHT = 987654321;
    static class Edge implements Comparable<Edge> {
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge){
            if(this.weight < edge.weight) return -1;
            else if(this.weight > edge.weight) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        int[][] dist = new int[N+1][N+1];
        int[][] res = new int[N+1][N+1];

        for(int k=1;k<=N;k++){
            graph[k] = new ArrayList<>();
            for(int l=1;l<=N;l++){
                dist[k][l] = MAX_WEIGHT;
            }
        }

        for(int k=0;k<M;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
            graph[to].add(new Edge(from, weight));
        }

        for(int k=1;k<=N;k++) {
            PriorityQueue<Edge> queue = new PriorityQueue<>();
            queue.add(new Edge(k, 0));
            dist[k][k] = 0;
            res[k][k] = k;
            while(!queue.isEmpty()){
                Edge cur = queue.poll();
                Iterator<Edge> iter = graph[cur.to].iterator();
                while(iter.hasNext()){
                    Edge ano = iter.next();
                    if(dist[k][ano.to] > dist[k][cur.to] + ano.weight && ano.to != k){
                        res[k][ano.to] = cur.to;
                        queue.offer(ano);
                    }
                    dist[k][ano.to] = Math.min(dist[k][ano.to], dist[k][cur.to] + ano.weight);
                }
            }

            for(int l=1;l<=N;l++){
                if(l == k) {
                    bw.append("- ");
                } else {
                    int m, tmp = 0;
                    for(m = l;m != k; m = res[k][m]){
                        tmp = m;
                    }
                    bw.append(String.format("%d ", tmp));
                }
            }
            bw.append("\n");
        }
        bw.flush();
    }
}
