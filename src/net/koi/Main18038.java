package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// Baekjoon KOI 2015 중등부 트리 문제 풀이
// 트리의 노드와 노드 간의 최단 경로는 어떻게 찾을까?
public class Main18038 {
    static int[] color;

    static int[] parent;
    static Set<Integer>[] children;
    static BufferedReader br;
    static StringTokenizer st;
    static int N, K;

    static void initialize() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        children = new Set[N];
        parent = new int[N];
        color = new int[N];

        Set<Integer> nodes = new HashSet<>();
        for(int k = 1; k < N; k++){
            nodes.add(k);
        }

        children[0] = nodes;
        for(int k = 1; k < children.length; k++){
            children[k] = new HashSet<>();
        }
    }

    static void paint(int from, int to, int color){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);
        Set<Integer> visited = new HashSet<>();
        visited.add(from);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.println(tmp);


            for(int v : children[tmp]) {
                if(!visited.contains(v)) {
                    queue.offer(v);
                    visited.add(v);
                }
            }
        }
    }

    static void move(int from, int to){

    }

    static void count(int from, int to){

    }

    public static void main(String[] args) throws IOException {
        initialize();
        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            switch(r) {
                case 1 :
                    int color = Integer.parseInt(st.nextToken());
                    paint(from, to, color);
                    break;
                case 2 :
                    move(from, to);
                    break;
                case 3 :
                    count(from, to);
                    break;
            }
        }
    }
}
