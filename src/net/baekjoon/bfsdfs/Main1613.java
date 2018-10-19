package net.baekjoon.bfsdfs;

import java.util.Scanner;

// Baekjoon 1613번 문제 풀이
public class Main1613 {
    static int V; // 정점의 수
    static int E; // 간선의 수
    static int S; // 추측을 원하는 수
    static Scanner s = new Scanner(System.in);
    static boolean[][] historyMap;
    public static void input(){
        V = s.nextInt();
        historyMap = new boolean[V+1][V+1];
        E = s.nextInt();
        for(int k=0;k<E;k++){
            int start, end;
            start = s.nextInt();
            end = s.nextInt();
            historyMap[start][end]=true;
        }
    }
    public static void functional(){
        for(int k=1;k<=V;k++){
            for(int i=1;i<=V;i++){
                for(int j=1;j<=V;j++){
                    historyMap[i][j] |= historyMap[i][k] & historyMap[k][j];
                }
            }
        }
    }
    public static void main(String[] args){
        input();
        functional();
        S = s.nextInt();
        int[] result = new int[S];
        for(int k=0;k<S;k++){
            int start = s.nextInt();
            int end = s.nextInt();
            if(historyMap[start][end]) result[k] = -1;
            else if(historyMap[end][start]) result[k] = 1;
            else result[k] = 0;
        }
        for(int k=0;k<S;k++){
            System.out.println(result[k]);
        }
    }
}
