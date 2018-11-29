package net.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Baekjoon 1949번 문제 풀이
// 우수 마을
public class Main1949 {
    static int N;
    static int[] cost;
    static boolean[] visited;
    static Map<Integer, List<Integer>> tree;

    static long dfs(int vtx, boolean checked){
        long result = 0L;
        visited[vtx] = true;
        for(int child : tree.get(vtx)){
            if(!visited[child]){
                if(checked){
                    result += dfs(child, false);
                } else {
                    result += Math.max(dfs(child, false), dfs(child, true) + cost[child]);
                }
            }
        }
        visited[vtx] = false;
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N+1];
        visited = new boolean[N+1];
        tree = new HashMap<>();
        for(int k=1;k<=N;k++){
            tree.put(k, new ArrayList<Integer>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int idx = 1;
        while(st.hasMoreTokens()){
            cost[idx++] = Integer.parseInt(st.nextToken());
        }
        for(int k=0;k<N-1;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            List<Integer> startVtxes = tree.get(start);
            List<Integer> endVtxes = tree.get(end);
            startVtxes.add(end);
            endVtxes.add(start);
        }
        System.out.println(Math.max(dfs(1, false), dfs(1, true) + cost[1]));
    }
}
