package net.baekjoon.topological;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 1516번 문제 풀이
public class Main1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        LinkedList<Integer>[] map = new LinkedList[N + 1];
        for(int k=1;k<=N;k++){
            map[k] = new LinkedList<>();
        }

        int[] dist = new int[N + 1];
        int[] time = new int[N + 1];
        StringTokenizer st;
        for(int k=1;k<=N;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int weight = Integer.parseInt(st.nextToken());
            time[k] = weight;

            while(st.hasMoreTokens()) {
                int v = Integer.parseInt(st.nextToken());
                if(v != -1) {
                    map[v].addLast(k);
                    dist[k] += 1;
                }
            }
        }

        int[] res = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for(int k=1;k<=N;k++){
            if(dist[k] == 0) {
                queue.offer(k);
                res[k] = time[k];
            }
        }

        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            for(int k : map[tmp]){
                res[k] = Math.max(res[k], res[tmp] + time[k]);
                dist[k] -= 1;
                if(dist[k] == 0)
                    queue.offer(k);
            }
        }

        for(int k = 1; k <= N; k++){
            System.out.println(res[k]);
        }
    }
}
