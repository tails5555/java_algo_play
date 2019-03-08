package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Baekjoon 10451번 문제
// 순환 사이클 문제
public class Main10451 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] node = new int[N + 1];
            for(int l = 1; l <= N; l++){
                node[l] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            Queue<Integer> queue;
            boolean[] visited = new boolean[N + 1];
            for(int l = 1; l <= N; l++){
                if(!visited[l]){
                    queue = new LinkedList<>();
                    queue.offer(l);
                    visited[l] = true;
                    while(!queue.isEmpty()){
                        int tmp = queue.poll();
                        if(!visited[node[tmp]]){
                            visited[node[tmp]] = true;
                            queue.offer(node[tmp]);
                        }
                    }
                    cnt += 1;
                }
            }

            System.out.println(cnt);
        }
    }
}
