package net.sw_expert.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D5 공통 조상 문제 풀이
// 풀이 참조...ㅜㅜ
public class Main1248 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            int[] parent = new int[V + 1];
            Set<Integer>[] children = new Set[V + 1];

            for(int l = 1; l <= V; l++){
                children[l] = new HashSet<>();
            }

            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 1; l <= E; l++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                children[from].add(to);
                parent[to] = from;
            }

            int common = 1;
            boolean[] visited = new boolean[V + 1];
            while(true){
                if(s1 != 1){
                    int pa = parent[s1];
                    if(visited[pa]){
                        common = pa;
                        break;
                    }
                    visited[pa] = true;
                    s1 = pa;
                }
                if(s2 != 1){
                    int pb = parent[s2];
                    if(visited[pb]){
                        common = pb;
                        break;
                    }
                    visited[pb] = true;
                    s2 = pb;
                }
            }

            int cnt = 0;
            Queue<Integer> queue = new LinkedList<>();
            for(int s : children[common]){
                queue.offer(s);
            }
            while(!queue.isEmpty()){
                int tmp = queue.poll();
                cnt += 1;
                for(int s : children[tmp]){
                    queue.offer(s);
                }
            }

            System.out.printf("#%d %d %d\n", k + 1, common, cnt + 1);
        }
    }
}
