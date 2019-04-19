package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int to;
    int weight;
    public Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge edge){
        return (this.weight < edge.weight) ? -1 : 1;
    }
}

// Baekjoon KOI 2005 중등부 본선 4번 엘리베이터 문제 풀이
// for each 대신 인덱스를 사용한 이유는 iterator 로 인한 메모리 초과를 방지하기 위함.
public class Main2593 {
    static final int MAX = 987654321;

    static void print(int[] prev, int elevator){
        if(elevator == 0) return;
        print(prev, prev[elevator]);
        System.out.println(elevator);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> floor = new ArrayList<>();
        List<List<Integer>> elevator = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        for(int k = 0; k <= N; k++){
            floor.add(new ArrayList<>());
        }

        int M = Integer.parseInt(st.nextToken());
        for(int k = 0; k <= M; k++){
            elevator.add(new ArrayList<>());
        }

        for(int k = 1; k <= M; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int unit = Integer.parseInt(st.nextToken());

            int tmp = start;
            while(tmp <= N){
                elevator.get(k).add(tmp);
                floor.get(tmp).add(k);
                tmp += unit;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] dist = new int[M + 1];
        Arrays.fill(dist, MAX);

        int[] prev = new int[M + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int k = 0; k < floor.get(A).size(); k++) {
            int s = floor.get(A).get(k);
            pq.add(new Edge(s, 1));
            dist[s] = 1;
        }

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(dist[e.to] < e.weight) continue;
            for(int f = 0; f < elevator.get(e.to).size(); f++){
                int flr = elevator.get(e.to).get(f);
                for(int el = 0; el < floor.get(flr).size(); el++){
                    int elv = floor.get(flr).get(el);
                    if(dist[elv] > e.weight + 1){
                        dist[elv] = e.weight + 1;
                        prev[elv] = e.to;
                        pq.add(new Edge(elv, dist[elv]));
                    }
                }
            }
        }

        int last = 0;
        int min = MAX;
        for(int e = 0; e < floor.get(B).size(); e++){
            int end = floor.get(B).get(e);
            if(min > dist[end]){
                min = dist[end];
                last = end;
            }
        }

        if(min == MAX){
            System.out.println(-1);
        } else {
            System.out.println(min);
            print(prev, last);
        }
    }
}
