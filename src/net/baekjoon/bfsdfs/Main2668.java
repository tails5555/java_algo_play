package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Baekjoon 2668번 숫자고르기 문제 풀이
// 그래프의 사이클을 찾는 방법을 간단히 풀어볼 수 있었던 문제. 괜찮은 문제.
public class Main2668 {
    static int[] visited;
    static int[] map;
    static void dfs(int idx){
        if(visited[idx] >= 2) return;
        visited[idx] += 1;
        dfs(map[idx]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N + 1];
        for(int k = 1; k <= N; k++){
            map[k] = Integer.parseInt(br.readLine());
        }

        visited = new int[N + 1];
        for(int k = 1; k <= N; k++) {
            dfs(k);
            for(int l = 1; l <= N; l++){
                if(visited[l] < 2)
                    visited[l] = 0;
            }
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int k = 1; k <= N; k++){
            if(visited[k] >= 2){
                sb.append(String.format("%d\n", k));
                cnt += 1;
            }
        }
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}
