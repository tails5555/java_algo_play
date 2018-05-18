package net.kang.picnic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 백준 2026번 문제 풀이
public class Main {
    static int K, N, F;
    static boolean[][] edges;
    static boolean[] visited;
    static boolean end;
    static List<Integer> result;
    public static void dfs(int friend){
        if(end) return;
        visited[friend]=true;
        result.add(friend);
        if(result.size()==K){
            for(int k : result){
                System.out.println(k);
            }
            end=true;
            return;
        }else {
            for (int k = friend + 1; k <= N; k++) {
                if (!visited[k]) {
                    boolean flag = true;
                    for (int l : result) {
                        if (!edges[k][l]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) dfs(k);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        K = s.nextInt();
        N = s.nextInt();
        edges = new boolean[N+1][N+1];
        F = s.nextInt();
        for(int k=0;k<F;k++){
            int x = s.nextInt();
            int y = s.nextInt();
            edges[x][y] = edges[y][x] = true;
        }

        for(int k=1;k<=N;k++){
            end=false;
            result = new ArrayList<>();
            visited = new boolean[N+1];
            dfs(k);
            if(end) return;
        }
        System.out.println(-1);
    }
}
