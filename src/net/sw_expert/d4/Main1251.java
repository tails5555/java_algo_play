package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// SW Expert D4 하나로 문제 풀이
public class Main1251 {
    static class Way implements Comparable<Way> {
        double dist;
        int from;
        int to;

        public Way(double dist, int from, int to){
            this.dist = dist;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Way o) {
            return (this.dist < o.dist) ? -1 : 1;
        }

        @Override
        public String toString() {
            return String.format("[%f, %d, %d]", this.dist, this.from, this.to);
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
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());

            long[] posX = new long[N];
            long[] posY = new long[N];
            parent = new int[N];

            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                parent[l] = l;
                posX[l] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                posY[l] = Long.parseLong(st.nextToken());
            }

            double E = Double.parseDouble(br.readLine());
            PriorityQueue<Way> pq = new PriorityQueue<>();
            for(int l = 0; l < N; l++){
                for(int m = 0; m < N; m++){
                    if(l != m) {
                        pq.offer(new Way((Math.pow(Math.abs(posX[l] - posX[m]), 2) + Math.pow(Math.abs(posY[l] - posY[m]), 2)) * E, l, m));
                    }
                }
            }

            double minCost = 0;
            while(!pq.isEmpty()) {
                Way tmp = pq.poll();

                int rootFrom = findRoot(tmp.from);
                int rootTo = findRoot(tmp.to);

                if(rootFrom != rootTo){
                    parent[rootFrom] = rootTo;
                    minCost = minCost + tmp.dist;
                }
            }

            System.out.printf("#%d %d\n", k + 1, Math.round(minCost));
        }
    }
}
