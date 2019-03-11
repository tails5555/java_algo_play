package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SW Expert D4 최소 스패닝 트리 문제 풀이
// 크루스칼 알고리즘 사용
public class Main3124 {
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parent;
    static int findRoot(int a){
        if(parent[a] == a) return a;
        else {
            parent[a] = findRoot(parent[a]);
            return parent[a];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Edge> pq;
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            parent = new int[V + 1];
            pq = new PriorityQueue<>();

            for(int l = 1; l <= V; l++){
                parent[l] = l;
            }

            for(int l = 0; l < E; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int dist = Integer.parseInt(st.nextToken());
                pq.offer(new Edge(from, to, dist));
                pq.offer(new Edge(to, from, dist));
            }

            long ans = 0L;
            while(!pq.isEmpty()){
                Edge tmp = pq.poll();

                int rootFrom = findRoot(tmp.from);
                int rootTo = findRoot(tmp.to);

                if(rootFrom != rootTo) {
                    parent[rootFrom] = rootTo;
                    ans = ans + (long) tmp.weight;
                }
            }

            System.out.printf("#%d %d\n", k + 1, ans);
        }
    }
}
