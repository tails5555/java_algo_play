package net.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 1289 번 문제 풀이
// 플로이드 워샬은 시간 초과 걸림.
public class Main1289 {
    static final int MAX = 1000000001;
    static final int DIV = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] tree = new int[N+1][N+1];
        for(int k=1;k<=N;k++){
            for(int l=1;l<=N;l++){
                tree[k][l] = MAX;
            }
        }
        StringTokenizer st;

        for(int k=0;k<N-1;k++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[start][end] = tree[end][start] = weight;
        }

        for(int m=1;m<=N;m++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(tree[i][m] * tree[m][j] > 0)
                        tree[i][j] = Math.min(tree[i][j], tree[i][m] * tree[m][j]);
                }
            }
        }

        int res = 0;
        for(int k=1;k<=N;k++){
            for(int l=k+1;l<=N;l++){
                res = (res + tree[k][l]) % DIV;
            }
        }
        System.out.println(res);
    }
}
