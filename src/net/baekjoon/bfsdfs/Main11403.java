package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 11403 경로 찾기 문제 풀이
public class Main11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        int[][] result = new int[N][N];
        for(int k=0;k<N;k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while(st.hasMoreTokens()){
                graph[k][idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0;k<N;k++){
            for(int l=0;l<N;l++) {
                Stack<Integer> stack = new Stack<>();
                Set<Integer> visited = new HashSet<>();
                stack.push(k);
                while (!stack.isEmpty()) {
                    int tmp = stack.pop();
                    int[] tmpVtx = graph[tmp];
                    for(int x=0;x<N;x++) {
                        if (!visited.contains(x) && tmpVtx[x] == 1) {
                            visited.add(x);
                            stack.push(x);
                        }
                    }
                }
                if (visited.contains(l)) result[k][l] = 1;
                else result[k][l] = 0;
            }
        }

        for(int k=0;k<N;k++){
            for(int l=0;l<N;l++){
                System.out.printf("%d ", result[k][l]);
            }
            System.out.println();
        }
    }
}
