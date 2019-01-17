package net.baekjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 1939번 중량제한 문제 풀이
public class Main1939 {
    static boolean bfs(int weight, int start, int end, Map<Integer, List<int[]>> map){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[map.keySet().size() + 1];
        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(tmp == end) return true;
            for(int[] node : map.get(tmp)){
                if(!visited[node[0]] && weight <= node[1]) {
                    queue.offer(node[0]);
                    visited[node[0]] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int k=1;k<=N;k++){
            map.put(k, new ArrayList<>());
        }

        int a, b, c;
        for(int k=0;k<M;k++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            List<int[]> toIdx = map.get(a);
            toIdx.add(new int[] { b, c });
            List<int[]> fromIdx = map.get(b);
            fromIdx.add(new int[] { a, c });
            map.put(a, toIdx);
            map.put(b, fromIdx);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        int l = 0;
        int r = 1000000001;
        int answer = 0;

        while(l <= r) {
            int m = (l + r) / 2;
            if(bfs(m, from, to, map)) {
                answer = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.println(answer);
    }
}
