package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// SW Expert D4 Contract 문제 풀이
public class Main1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[][] map;
        boolean[] visited;
        Queue<List<Integer>> queue;
        for(int k = 0; k < 10; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            map = new boolean[101][101];
            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                map[start][end] = true;
            }

            visited = new boolean[101];
            queue = new LinkedList<>();
            queue.offer(Arrays.asList(S));
            visited[S] = true;

            int res = Integer.MIN_VALUE;
            while(!queue.isEmpty()){
                List<Integer> tmp = queue.poll();
                List<Integer> list = new ArrayList<>();
                for(int t : tmp) {
                    for (int l = 1; l <= 100; l++) {
                        if (map[t][l] && !visited[l]) {
                            visited[l] = true;
                            list.add(l);
                        }
                    }
                }
                if(list.size() > 0)
                    queue.offer(list);
                else {
                    for(int t : tmp){
                        res = Math.max(t, res);
                    }
                }
            }

            System.out.printf("#%d %d\n", k+1, res);
        }
    }
}
