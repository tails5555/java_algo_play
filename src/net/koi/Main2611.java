package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// Baekjoon KOI 중등부 2004 본선 4번 자동차 경주 문제 풀이
// dijkstra 에서는 최소의 비용을 요구했지만, 이 문제는 반대로 최대 경로를 요구하여 반대의 요구사항만 잘 맞추면 풀 수 있는 문제.
public class Main2611 {
    static final int MIN = -987654321;

    static BufferedReader br;
    static StringTokenizer st;

    static int N, res;
    static List<Edge>[] map;

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

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new ArrayList[N + 1];
        for(int k = 1; k <= N; k++){
            map[k] = new ArrayList<>();
        }

        int M = Integer.parseInt(br.readLine());
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            map[from].add(new Edge(to, score));
        }
    }

    static void dijkstra(){
        int[] dist = new int[N + 1];
        int[] record = new int[N + 1];
        for(int k = 2; k <= N; k++) {
            dist[k] = MIN;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(dist[cur.to] > cur.weight) continue;
            Iterator<Edge> iter = map[cur.to].iterator();
            while(iter.hasNext()){
                Edge ano = iter.next();
                if(dist[ano.to] < ano.weight + cur.weight){
                    dist[ano.to] = ano.weight + cur.weight;
                    record[ano.to] = cur.to;
                    if(ano.to != 1) pq.offer(new Edge(ano.to, dist[ano.to]));
                }
            }
        }

        System.out.println(dist[1]);

        Stack<Integer> stack = new Stack<>();
        int k = record[1];
        while(k != 1){
            stack.push(k);
            k = record[k];
        }

        System.out.printf("%d ", 1);
        while(!stack.isEmpty()){
            System.out.printf("%d ", stack.peek());
            stack.pop();
        }
        System.out.println("1");
    }

    public static void main(String[] args) throws IOException {
        input();
        dijkstra();
    }
}
