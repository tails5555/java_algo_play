package net.baekjoon.disjoint_set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 1717 집합의 표현 문제 풀이
class DisjointSet {
    private int[] parent;
    private int[] c_cnt;

    public DisjointSet(int size){
        this.parent = new int[size + 1];
        this.c_cnt = new int[size + 1];
        for(int k = 0; k <= size; k++){
            this.parent[k] = k; // 단일 집합으로 지정. (0), (1), (2), (3)...
        }
    }

    public int find(int child){
        if(parent[child] == child) return child;
        return parent[child] = find(parent[child]);
    }

    public void merge(int a, int b){
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (c_cnt[a] > c_cnt[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        parent[b] = a;
        if(c_cnt[a] == c_cnt[b]) c_cnt[b]++;
    }
}

public class Main1717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        DisjointSet d_set = new DisjointSet(N);
        for(int k = 0; k < M; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int q = Integer.parseInt(st.nextToken());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            if(q == 0) {
                d_set.merge(v1, v2);
            }

            if(q == 1) {
                if(d_set.find(v1) == d_set.find(v2)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
