package net.sw_expert.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// SW Expert D6 작업 순서 문제 풀이
public class Main1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int k = 0; k < 10; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] degree = new int[N + 1];
            LinkedList<Integer>[] graph = new LinkedList[N + 1];
            for(int l = 1; l <= N; l++)
                graph[l] = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < M; l++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from].add(to);
                degree[to] += 1;
            }

            StringBuilder sb = new StringBuilder();
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            for(int l = 1; l <= N; l++){
                if(degree[l] == 0 && !set.contains(l)) {
                    queue.offer(l);
                    set.add(l);
                    while(!queue.isEmpty()) {
                        int tmp = queue.poll();
                        sb.append(String.format("%d ", tmp));
                        for(int v : graph[tmp]){
                            degree[v] -= 1;
                            if(degree[v] == 0 && !set.contains(v)) {
                                queue.offer(v);
                                set.add(v);
                            }
                        }
                    }
                }
            }

            System.out.printf("#%d %s\n", k + 1, sb.toString());
        }
    }
}
